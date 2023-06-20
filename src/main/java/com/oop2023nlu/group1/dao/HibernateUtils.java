package com.oop2023nlu.group1.dao;

import com.oop2023nlu.group1.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static {
        System.out.println("config hibernate");
        Configuration conf = new Configuration();

        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/clinic");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "");
        props.put(Environment.SHOW_SQL, "true");
//        props.put(Environment.HBM2DDL_AUTO, "create-drop");
        props.put(Environment.HBM2DDL_AUTO, "update");

        conf.setProperties(props);
        conf.addAnnotatedClass(Patient.class);
        conf.addAnnotatedClass(Visit.class);
        conf.addAnnotatedClass(Medicine.class);
        conf.addAnnotatedClass(PrescriptionMedicine.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

//    public static void main(String[] args) {
//        List<Patient> patients = new ArrayList<>();
//
//        patients.add(new Patient("001","Nguyễn Văn Hiếu", "35 đường số 4, Trường Thọ, Thủ Đức", "0798631497", 2001, true));
//        patients.add(new Patient("002", "Nguyễn Trường Đình", "Trần Phú, Phủ Hà, Quận 12", "0163149752", 2001, true));
//        patients.add(new Patient("003", "Trần Đình Danh", "KTX A Nông Lâm, Linh Trung, Thủ Đức", "0786951463", 2001, true));
//        patients.add(new Patient("004", "Nguyễn Hoàng Đức", "Làng đại học, Linh Trung, Thủ Đức", "0335942367", 2001, true));
//        patients.add(new Patient("005", "Nguyễn Văn Minh", "Làng đại học, Linh Trung, Thủ Đức", "0339741358", 2001, false));
//        for (Patient patient : patients) {
//            System.out.println(PatientDAO.savePatient(patient));
//        }
//    }
}
