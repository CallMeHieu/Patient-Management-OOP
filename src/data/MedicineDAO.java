package data;

import java.util.ArrayList;
import java.util.List;

import model.Medicine;

public class MedicineDAO {
	public static List<Medicine> medicines = new ArrayList<>();
	static {
		medicines.add(new Medicine("SP001", "Albuterol", "Hộp", "1 viên mỗi 6 giờ"));
		medicines.add(new Medicine("SP002", "Gabapentin", "Ống", "2 ống mỗi ngày"));
		medicines.add(new Medicine("SP003", "Amoxicillin", "Ống", "1 ống mỗi 8 giờ"));
		medicines.add(new Medicine("SP004", "Levothyroxine", "Ống", "1 ống mỗi sáng"));
		medicines.add(new Medicine("SP005", "Ibuprofen", "Vỉ", "1 viên mỗi 6-8 giờ"));
		medicines.add(new Medicine("SP006", "Venlafaxine", "Vỉ", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP007", "Pregabalin", "Hộp", "1 viên mỗi tối"));
		medicines.add(new Medicine("SP008", "Ranitidine", "Ống", "1 ống mỗi 12 giờ"));
		medicines.add(new Medicine("SP009", "Tramadol", "Ống", "1 ống mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP010", "Simvastatin", "Vỉ", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP011", "Codeine", "Hộp", "1 viên mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP012", "Sertraline", "Vỉ", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP013", "Oxycodone", "Ống", "1 ống mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP014", "Cetirizine", "Hộp", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP015", "Paracetamol", "Hộp", "1-2 viên mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP016", "Amlodipine", "Ống", "1 ống mỗi ngày"));
		medicines.add(new Medicine("SP017", "Citalopram", "Hộp", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP018", "Metformin", "Ống", "1 ống mỗi bữa ăn"));
		medicines.add(new Medicine("SP019", "Diazepam", "Vỉ", "1-2 viên mỗi 6-8 giờ"));
		medicines.add(new Medicine("SP020", "Losartan", "Ống", "1 ống mỗi ngày"));
		medicines.add(new Medicine("SP021", "Fluoxetine", "Hộp", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP022", "Aspirin", "Hộp", "1-2 viên mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP023", "Omeprazole", "Hộp", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP024", "Lisinopril", "Vỉ", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP025", "Escitalopram", "Ống", "1 ống mỗi ngày"));
		medicines.add(new Medicine("SP026", "Atorvastatin", "Hộp", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP027", "Loperamide", "Vỉ", "1 viên mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP028", "Prednisone", "Vỉ", "1 viên mỗi ngày"));
		medicines.add(new Medicine("SP029", "Morphine", "Ống", "1 ống mỗi 4-6 giờ"));
		medicines.add(new Medicine("SP030", "Metoprolol", "Vỉ", "1 viên mỗi ngày"));

	}

	public static void saveMedicine(Medicine medicine) {
		medicines.add(medicine);
	}

	public static Medicine findMedicineById(String id) {
		for (Medicine medicine : medicines) {
			if (medicine.getMedicineID().equals(id)) {
				return medicine;
			}
		}
		return null;
	}

	public static boolean deleteMedicine(String id) {
		for (int i = 0; i < medicines.size(); i++) {
			if (medicines.get(i).getMedicineID().equals(id)) {
				medicines.remove(i);
				return true;
			}
		}
		return false;
	}

	public static boolean updateMedicine(Medicine medicine) {
		for (int i = 0; i < medicines.size(); i++) {
			if (medicines.get(i).getMedicineID().equals(medicine.getMedicineID())) {
				medicines.set(i, medicine);
				return true;
			}
		}
		return false;
	}
}
