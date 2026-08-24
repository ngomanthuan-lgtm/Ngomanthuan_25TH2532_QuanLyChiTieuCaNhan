💸 ỨNG DỤNG QUẢN LÝ CHI TIÊU CÁ NHÂN
🎓 ĐỒ ÁN CUỐI KỲ MÔN LẬP TRÌNH THIẾT BỊ DI ĐỘNG
📌 THÔNG TIN ĐỒ ÁN
Sinh viên thực hiện: Ngô Mẫn Thuận
Mã số sinh viên: 25TH2532
Lớp: CC25CTH
Giảng viên hướng dẫn: Mai Cường Thọ
Trường: Đại học Nha Trang (NTU)
Nền tảng phát triển: Android Studio, Ngôn ngữ Java, Cơ sở dữ liệu SQLite
📸 HÌNH ẢNH GIAO DIỆN ỨNG DỤNG
1. 📱 Màn hình chính Danh sách Chi tiêu & Thống kê Số dư
<img width="278" height="431" alt="Hình 1" src="https://github.com/user-attachments/assets/d36d2906-852b-469f-8888-843da0051172" />

Hình 1.1: Giao diện Màn hình chính hiển thị Header sinh viên Ngô Mẫn Thuận - 25TH2532, Thẻ tổng quan Số dư, Tổng Thu, Tổng Chi và Danh sách giao dịch.

2. ➕ Màn hình Thêm & Chỉnh sửa giao dịch Thu / Chi
<img width="308" height="429" alt="Hình 2" src="https://github.com/user-attachments/assets/4f384b4a-a675-4261-8a86-9fa158bbebfc" />


Hình 1.2: Màn hình nhập liệu cho phép chọn Thu nhập (+), Chi tiêu (-), nhập Tên, Số tiền, chọn Danh mục qua Spinner và chọn Ngày qua DatePickerDialog.

3. 🧩 Giao diện Khung mẫu từng dòng giao dịch (item_transaction.xml)
<img width="281" height="486" alt="Hình 3" src="https://github.com/user-attachments/assets/4cf4c436-08ba-41e8-a0ab-a68a4fd2b2e1" />


Hình 1.3: Giao diện từng mục hiển thị Tên khoản, Danh mục, Ngày, Ghi chú và Số tiền tô màu xanh lá (Thu) / đỏ (Chi).

🚀 CÁC TÍNH NĂNG NỔI BẬT CỦA ỨNG DỤNG
1. 💵 Quản lý Số dư & Thống kê Thu Chi
Hiển thị danh sách các khoản thu/chi trực quan bằng CardView và ListView.
Nhận diện phân biệt loại giao dịch rõ ràng qua màu sắc: Khoản Thu (Màu xanh lá) và Khoản Chi (Màu đỏ).
Đơn giá định dạng tiền tệ chuẩn VNĐ qua DecimalFormat (Ví dụ: 15,000,000 VNĐ, 35,000 VNĐ).
2. ➕ Thêm Giao Dịch Mới
Màn hình nhập liệu tiện lợi cho phép chọn loại giao dịch (Thu nhập (+), Chi tiêu (-)), nhập Số tiền, chọn Danh mục qua Spinner và chọn Ngày giao dịch qua DatePickerDialog.
3. ✏️ Sửa & Xóa Giao Dịch
Chỉnh sửa: Bấm chuột vào khoản giao dịch bất kỳ trên danh sách ➔ Mở màn hình cập nhật thông tin.
Xóa giao dịch: Nhấn giữ (Long Click) mục bất kỳ ➔ Hiển thị Hộp thoại AlertDialog xác nhận xóa dữ liệu khỏi CSDL SQLite.
4. 💾 Cơ sở dữ liệu SQLite (DatabaseHelper.java)
Lưu trữ dữ liệu bền vững offline trên thiết bị.
Tự động tính toán Số Dư Hiện Tại = Tổng Thu - Tổng Chi bằng câu lệnh SQL SUM.
Đồ án được thực hiện bởi sinh viên Ngô Mẫn Thuận - MSSV: 25TH2532.
