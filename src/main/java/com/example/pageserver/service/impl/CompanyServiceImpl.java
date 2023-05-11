package com.example.pageserver.service.impl;

import com.example.pageserver.entity.School;
import com.example.pageserver.entity.Student;
import com.example.pageserver.enums.impl.ExceptionEnum;
import com.example.pageserver.exception.children.MyException;
import com.example.pageserver.mapper.CompanyMapper;
import com.example.pageserver.entity.Company;
import com.example.pageserver.mapper.StudentMapper;
import com.example.pageserver.service.CompanyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    CompanyMapper companyMapper;
    @Resource
    StudentMapper studentMapper;
    @Override
    public Company selectByCid(Integer cid) {
        return companyMapper.selectByCid(cid);
    }

    @Override
    public Company checkInfo(String username, String password) {
        Company company = companyMapper.checkInfo(username,password);
        if (company == null) {
            throw new MyException(ExceptionEnum.LOGIN_PARAMETER_EXCEPTION);
        }
        return company;
    }

    @Override
    public List<Company> selectAll() {
        return companyMapper.selectAll();
    }

    @Override
    public void sendResume(Integer cid, Integer sid) {
        Company company = companyMapper.selectSend(cid);
        String listStr = company.getReadyEmployee();
        /*将字符串转化为list集合*/
        String[] splitList = listStr.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        list.add(sid.toString());
        /*去重*/
        list = new ArrayList<>(new TreeSet<>(list));
        System.out.println(list);
        /*将list集合转化为字符串*/
        listStr = String.join(",",list);
        System.out.println(listStr);
        company.setReadyEmployee(listStr);
        if(companyMapper.sendResume(company) != 1){
            throw new MyException(ExceptionEnum.UPDATE_PARAMETER_EXCEPTION);
        }
    }

    @Override
    public void updateInfo(Company company) {
        if(companyMapper.updateInfo(company) != 1) throw new MyException(ExceptionEnum.UPDATE_PARAMETER_EXCEPTION);
    }

    @Override
    public List<Student> selectAllApply(Integer cid) {
        String listStr = companyMapper.selectAllApply(cid).getReadyEmployee();
        String[] splitList = listStr.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        List<Student> stList = new ArrayList<>();
        for (String sid:list) {
            stList.add(studentMapper.selectBySid(Integer.parseInt(sid)));
        }
        return stList;
    }

    @Override
    public List<Student> selectAllEmployee(Integer cid) {
        String listStr = companyMapper.selectAllEmployee(cid).getEmployee();
        String[] splitList = listStr.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        List<Student> stList = new ArrayList<>();
        for (String sid:list) {
            stList.add(studentMapper.selectBySid(Integer.parseInt(sid)));
        }
        return stList;
    }

    @Override
    public void applyEmployee(Integer sid,Integer cid) {
        Company company = companyMapper.selectSend(cid);
        String listStr = company.getReadyEmployee();
        String listStr2 = company.getEmployee();
        /*将字符串转化为list集合*/
        String[] splitList = listStr.split(",");
        String[] splitList2 = listStr2.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        List<String> list2 = new ArrayList<>(Arrays.asList(splitList2));
        list.remove(sid.toString());
        list2.add(sid.toString());
        /*去重*/
        list = new ArrayList<>(new TreeSet<>(list));
        list2 = new ArrayList<>(new TreeSet<>(list2));
        /*将list集合转化为字符串*/
        listStr = String.join(",",list);
        listStr2 = String.join(",",list2);
        company.setReadyEmployee(listStr);
        company.setEmployee(listStr2);
        Student student = studentMapper.selectBySid(sid);
        student.setState("已就业");
        studentMapper.updateState(student);
        int num = companyMapper.applyEmployee(company);
        int num2 = companyMapper.puaEmployee(company);
        if(num != 1&& num2 != 1){
            throw new MyException(ExceptionEnum.UPDATE_PARAMETER_EXCEPTION);
        }
    }

    @Override
    public void puaEmployee(Integer cid, Integer sid) {
        Company company = companyMapper.selectSend(cid);
        String listStr = company.getEmployee();
        /*将字符串转化为list集合*/
        String[] splitList = listStr.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(splitList));
        list.remove(sid.toString());
        /*去重*/
        list = new ArrayList<>(new TreeSet<>(list));
        /*将list集合转化为字符串*/
        listStr = String.join(",",list);
        company.setEmployee(listStr);
        Student student = studentMapper.selectBySid(sid);
        student.setState("未就业");
        studentMapper.updateState(student);
        int num = companyMapper.puaEmployee(company);
        if(num != 1){
            throw new MyException(ExceptionEnum.UPDATE_PARAMETER_EXCEPTION);
        }
    }

}
