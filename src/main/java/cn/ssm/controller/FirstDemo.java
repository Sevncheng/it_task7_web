package cn.ssm.controller;

import cn.ssm.entity.EmailCode;
import cn.ssm.entity.PhoneCode;
import cn.ssm.entity.Student;
import cn.ssm.service.EmailCodeService;
import cn.ssm.service.PhoneCodeService;
import cn.ssm.service.StudentService;
import cn.ssm.utils.EmailSendUtil;
import cn.ssm.utils.HeardUpload;
import cn.ssm.utils.PhoneSendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@Controller
public class FirstDemo {

    @Autowired
    private PhoneCodeService phoneCodeService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PhoneSendUtil phoneSendUtil;
    @Autowired
    private EmailCodeService emailCodeService;
    @Autowired
    private EmailSendUtil emailSendUtil;
    @Autowired
    private HeardUpload heardUpload;


    //默认拦截进入主页
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homeUI(){
        return "/WEB-INF/studentHome.jsp";
    }


    //跳转到登录页面
    @RequestMapping(value = "/loginUI",method = RequestMethod.GET)
    public String loginUI(){
        return "/WEB-INF/loginUI.jsp";
    }


    //跳转到学生注册页面
    @RequestMapping(value = "/studentUI")
    public String studentUI(){
        return "/WEB-INF/studentAddUI.jsp";
    }

    //跳转到个人中心
    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public String update(){
        return "/WEB-INF/studentUI.jsp";
    }


    //用户更新后重定向回首页
    @RequestMapping(value = "/student/{id}",method = RequestMethod.PUT)
    public String updateStudent(Student student,HttpServletRequest request){
        studentService.update(student);
        //重新赋值session中的用户
        Student temp = studentService.findById(student.getStudentId());
        request.getSession().setAttribute("loginstudent", temp);
        return "redirect:/";
    }

    //用户变更头像
    @RequestMapping(value = "/student/head",method = RequestMethod.POST)
    public String updateStudent(String studentId,Model model,HttpServletRequest request,MultipartFile file) throws IOException {
        String imgName = file.getOriginalFilename();
        String suffix = imgName.substring(imgName.lastIndexOf(".")+1);
        if(suffix.equals("jpg")||suffix.equals("gif")) {
            //将文件命名改为UUID+文件名
            String fileName = studentId + imgName;
            if(heardUpload.getNumb().equals("1")) {
                //使用该工具的七牛传送方法,上传到七牛
                heardUpload.QiniusendImage(file.getBytes(), fileName);
                //把用户头像路径更新 增加七牛的前缀路径!
                String headinfo = "http://oyin3xo1y.bkt.clouddn.com/" + fileName;
                Student temp = studentService.findById(studentId);
                temp.setStudentHead(headinfo);
                studentService.updateHead(temp);
                //覆盖session中的记录
                request.getSession().setAttribute("loginstudent", temp);
            }else {
                //使用该工具的阿里传送方法,上传到阿里
                heardUpload.AlisendImage(file.getInputStream(), fileName);
                //把用户头像路径更新 增加阿里的前缀路径!
                String headinfo = "http://task7.oss-cn-hangzhou.aliyuncs.com/"+ fileName;
                Student temp = studentService.findById(studentId);
                temp.setStudentHead(headinfo);
                studentService.updateHead(temp);
                //覆盖session中的记录
                request.getSession().setAttribute("loginstudent", temp);
            }
        }
        return "redirect:/";
    }




    //执行用户注册动作
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public String studentAdd(Student student,String checkNumber){
        String str = "redirect:/studentUI";
        try {
            PhoneCode pc = phoneCodeService.checkCode(
                    new PhoneCode(checkNumber, student.getStudentPhone())
            );
            Long checktime = new Date().getTime() - pc.getCodeTime();
            if (pc != null && checktime <= (1000 * 120)) {
                //为用户添加唯一UUID
                UUID uu = UUID.randomUUID();
                String id = uu.toString().replace("-", "");
                student.setStudentId(id);
                //为用户设置默认头像
                student.setStudentHead("http://oyin3xo1y.bkt.clouddn.com/moren.jpg");
                //将用户状态设置为0 因为没有进行邮箱绑定,如绑定邮箱后状态则为1是有效状态
                student.setStudentState(0);
                studentService.add(student);
                //注册成功后重定向到主页
                str = "redirect:/";
            }
        }catch (Exception e){}
        return str;
    }


    //异步生成验证码,并且记录时间和对应手机号保存到数据
    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public void savecode(String studentPhone,HttpServletResponse response) throws IOException {
        //防攻击通道,查询5分钟内发送频率是否超过5次
        PhoneCode pc = new PhoneCode();
        pc.setCodeTime(new Date().getTime());
        pc.setCodePhone(studentPhone);
        if(phoneCodeService.count(pc)<=5) {
            //随机生成6位数数字
            String num = new Random().nextInt(999999) + "";
            //将数据保存到数据库
            PhoneCode phoneCode = new PhoneCode(new Date().getTime(), num, studentPhone);
            phoneCodeService.save(phoneCode);
            //将验证码发送给我们的用户手机上
            phoneSendUtil.sendSMS(studentPhone, num);
        }
    }

    //执行用户登录动作
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String studentLogin(Student student, HttpServletRequest request){
        Student temp = studentService.findByStudent(student);
        //判断登录是否成功
        if(temp!=null){
            Date date = new Date();
            request.getSession().setAttribute("time",date);
            request.getSession().setAttribute("loginstudent",temp);
        }
        //无论登录是否成功都重定回主页
        return "redirect:/";
    }



    //用户列表展示
    @RequestMapping(value = "/studentList",method = RequestMethod.GET)
    public String studentList(Model model){
        List<Student> list = studentService.findAll();
        model.addAttribute("studentList",list);
        return "/WEB-INF/studentList.jsp";
    }



    //用户退出登录
    @RequestMapping(value = "/desk",method = RequestMethod.GET)
    public String updateStudent(HttpServletRequest request){
        request.getSession().removeAttribute("loginstudent");
        request.getSession().removeAttribute("time");
        return "redirect:/";
    }



    //异步生成邮箱验证码,并且记录时间和对应邮箱
    @RequestMapping(value = "/email",method = RequestMethod.POST)
    public void savecodem(String studentEmail,HttpServletResponse response) throws IOException {
        //防攻击通道,查询5分钟内发送频率是否超过5次
        EmailCode ec = new EmailCode();
        ec.setCodeTime(new Date().getTime());
        ec.setCodeEmail(studentEmail);
        if(emailCodeService.count(ec)<=5) {
            //随机生成6位数数字
            String num = new Random().nextInt(999999) + "";
            //将数据保存到数据库
            EmailCode emailCode = new EmailCode(new Date().getTime(), num, studentEmail);
            emailCodeService.save(emailCode);
            //将验证码发送给我们的用户有邮箱
            emailSendUtil.send(studentEmail, num);
        }
    }

    //用户邮箱验证绑定
    @RequestMapping(value = "/student/email",method = RequestMethod.POST)
    public String updateEmail(String studentEmail,String checkNumber,String studentId,HttpServletRequest request){
        try {
            if (studentEmail != null && studentEmail != "") {
                EmailCode ec = emailCodeService.checkCode(
                        new EmailCode(checkNumber, studentEmail)
                );
                Long checktime = new Date().getTime() - ec.getCodeTime();
                if (ec != null && checktime <= (1000 * 120)) {
                    //验证通过
                    Student temp = studentService.findById(studentId);
                    temp.setStudentEmail(studentEmail);
                    studentService.updateEmail(temp);
                    //覆盖session
                    request.getSession().setAttribute("loginstudent", temp);
                }
            }
        }catch (Exception e){}
        return "redirect:/";
    }
}

