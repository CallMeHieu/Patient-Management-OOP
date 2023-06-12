package com.oop2023nlu.group1.dao;

import com.oop2023nlu.group1.model.Medicine;
import com.oop2023nlu.group1.model.Patient;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {

	public static Medicine saveMedicine(Medicine medicine) {
		Session session = HibernateUtils.getFACTORY().openSession();
		Transaction transaction = null;
		Medicine savedMedicine = null;
		try {
			transaction = session.beginTransaction();
			session.save(medicine);
			session.getTransaction().commit();
			savedMedicine = session.get(Medicine.class, medicine.getMedicineID());
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return savedMedicine;
	}

	public static Medicine findMedicineById(String id) {
		Medicine medicine = null;
		try (Session session = HibernateUtils.getFACTORY().openSession()) {
			medicine = session.get(Medicine.class, id);
		}
		return medicine;
	}

	public static List<Medicine> findAllMedicines() {
		List<Medicine> medicines = new ArrayList<>();
		try (Session session = HibernateUtils.getFACTORY().openSession()) {
			medicines = session.createQuery("from Medicine", Medicine.class).getResultList();
		}
		return medicines;
	}

	public static boolean deleteMedicine(String id) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			Medicine medicine = session.get(Medicine.class, id);
			if (medicine != null) {
				session.delete(medicine);
				transaction.commit();
				return true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateMedicine(Medicine medicine) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getFACTORY().openSession()) {
			transaction = session.beginTransaction();
			session.update(medicine);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}
	public static List<Medicine> findAllByCharName(String charName) {
		List<Medicine> result = new ArrayList<>();
		for (Medicine medicine : findAllMedicines()) {
			if (medicine.getName().toLowerCase().contains(charName.toLowerCase())) {
				result.add(medicine);
			}
		}
		return result;
	}
//	public static void main(String[] args) {
////		init data
//		List<Medicine> medicines = new ArrayList<>();
//		medicines.add(new Medicine("SP001", "Albuterol", "Hộp", "1 viên mỗi 6 giờ"));
//		medicines.add(new Medicine("SP002", "Gabapentin", "Ống", "2 ống mỗi ngày"));
//		medicines.add(new Medicine("SP003", "Amoxicillin", "Ống", "1 ống mỗi 8 giờ"));
//		medicines.add(new Medicine("SP004", "Levothyroxine", "Ống", "1 ống mỗi sáng"));
//		medicines.add(new Medicine("SP005", "Ibuprofen", "Vỉ", "1 viên mỗi 6-8 giờ"));
//		medicines.add(new Medicine("SP006", "Venlafaxine", "Vỉ", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP007", "Pregabalin", "Hộp", "1 viên mỗi tối"));
//		medicines.add(new Medicine("SP008", "Ranitidine", "Ống", "1 ống mỗi 12 giờ"));
//		medicines.add(new Medicine("SP009", "Tramadol", "Ống", "1 ống mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP010", "Simvastatin", "Vỉ", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP011", "Codeine", "Hộp", "1 viên mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP012", "Sertraline", "Vỉ", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP013", "Oxycodone", "Ống", "1 ống mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP014", "Cetirizine", "Hộp", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP015", "Paracetamol", "Hộp", "1-2 viên mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP016", "Amlodipine", "Ống", "1 ống mỗi ngày"));
//		medicines.add(new Medicine("SP017", "Citalopram", "Hộp", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP018", "Metformin", "Ống", "1 ống mỗi bữa ăn"));
//		medicines.add(new Medicine("SP019", "Diazepam", "Vỉ", "1-2 viên mỗi 6-8 giờ"));
//		medicines.add(new Medicine("SP020", "Losartan", "Ống", "1 ống mỗi ngày"));
//		medicines.add(new Medicine("SP021", "Fluoxetine", "Hộp", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP022", "Aspirin", "Hộp", "1-2 viên mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP023", "Omeprazole", "Hộp", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP024", "Lisinopril", "Vỉ", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP025", "Escitalopram", "Ống", "1 ống mỗi ngày"));
//		medicines.add(new Medicine("SP026", "Atorvastatin", "Hộp", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP027", "Loperamide", "Vỉ", "1 viên mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP028", "Prednisone", "Vỉ", "1 viên mỗi ngày"));
//		medicines.add(new Medicine("SP029", "Morphine", "Ống", "1 ống mỗi 4-6 giờ"));
//		medicines.add(new Medicine("SP030", "Metoprolol", "Vỉ", "1 viên mỗi ngày"));
//		for(Medicine medicine : medicines){
//		saveMedicine(medicine);
//		}
//	}
}
