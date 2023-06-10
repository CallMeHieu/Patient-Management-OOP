package data;

import model.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    public static List<Patient> patients = new ArrayList<>();

    static {
        patients.add(new Patient("001", "Nguyễn Văn Hiếu", "35 đường số 4, Trường Thọ, Thủ Đức", "0798631497", 2001, true));
        patients.add(new Patient("002", "Nguyễn Trường Đình", "Trần Phú, Phủ Hà, Quận 12", "0163149752", 2001, true));
        patients.add(new Patient("003", "Trần Đình Danh", "KTX A Nông Lâm, Linh Trung, Thủ Đức", "0786951463", 2001, true));
        patients.add(new Patient("004", "Nguyễn Hoàng Đức", "Làng đại học, Linh Trung, Thủ Đức", "0335942367", 2001, true));
        patients.add(new Patient("005", "Nguyễn Văn Minh", "Làng đại học, Linh Trung, Thủ Đức", "0339741358", 2001, false));
    }
    public static void savePatient(Patient patient) {
        patients.add(patient);
    }


    public static Patient findPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public static boolean deletePatient(String id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(id)) {
                patients.remove(i);
                return true;
            }
        }
        return false;
    }

    public static boolean updatePatient(Patient patient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId().equals(patient.getId())) {
                patients.set(i, patient);
                return true;
            }
        }
        return false;
    }
}
