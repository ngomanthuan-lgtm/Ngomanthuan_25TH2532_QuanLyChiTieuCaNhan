ỨNG DỤNG QUẢN LÝ CHI TIÊU CÁ NHÂN (EXPENSE MANAGEMENT APP)
🎓 ĐỒ ÁN CUỐI KỲ MÔN LẬP TRÌNH THIẾT BỊ DI ĐỘNG (ANDROID)
📌 THÔNG TIN ĐỒ ÁN
Sinh viên thực hiện: Ngô Mẫn Thuận
Mã số sinh viên: 25TH2532
Giảng viên hướng dẫn: Mai Cường Thọ
Trường: Đại học Nha Trang (NTU)
Nền tảng phát triển: Android Studio, Ngôn ngữ Java, Cơ sở dữ liệu SQLite
📸 HÌNH ẢNH GIAO DIỆN ỨNG DỤNG
1. 📱 Màn hình chính Danh sách Chi tiêu & Thống kê Số dư
Màn hình chính

Hình 1.1: Giao diện Màn hình chính hiển thị Header sinh viên Ngô Mẫn Thuận - 25TH2532, Thẻ tổng quan Số dư, Tổng Thu, Tổng Chi và Danh sách giao dịch.

2. ➕ Màn hình Thêm & Chỉnh sửa giao dịch Thu / Chi
Màn hình Thêm Sửa

Hình 1.2: Màn hình nhập liệu cho phép chọn Thu nhập (+), Chi tiêu (-), nhập Tên, Số tiền, chọn Danh mục qua Spinner và chọn Ngày qua DatePickerDialog.

3. 🧩 Giao diện Khung mẫu từng dòng giao dịch (item_transaction.xml)
Giao diện Item

Hình 1.3: Giao diện từng mục hiển thị Tên khoản, Danh mục, Ngày, Ghi chú và Số tiền tô màu xanh lá (Thu) / đỏ (Chi).

🚀 CÁC TÍNH NĂNG NỔI BẬT CỦA ỨNG DỤNG
1. 💵 Quản lý Số dư & Thống kê Thu Chi
Hiển thị danh sách các khoản thu/chi trực quan bằng CardView và ListView.
Nhận diện phân biệt loại giao dịch rõ ràng qua màu sắc: Khoản Thu (Màu xanh lá #2E7D32) và Khoản Chi (Màu đỏ #C62828).
Đơn giá định dạng tiền tệ chuẩn VNĐ qua DecimalFormat (Ví dụ: 15,000,000 VNĐ, 35,000 VNĐ).
2. ➕ Thêm Giao Dịch Mới
Màn hình nhập liệu tiện lợi cho phép chọn loại giao dịch (Thu nhập (+), Chi tiêu (-)), nhập Số tiền, chọn Danh mục (Ăn uống, Lương, Mua sắm, Học tập, Giải trí...) qua Spinner, và chọn Ngày giao dịch qua DatePickerDialog.
3. ✏️ Sửa & Xóa Giao Dịch
Chỉnh sửa: Bấm chuột vào khoản giao dịch bất kỳ trên danh sách ➔ Mở màn hình cập nhật thông tin.
Xóa giao dịch: Nhấn giữ (Long Click) mục bất kỳ ➔ Hiển thị Hộp thoại AlertDialog xác nhận xóa dữ liệu khỏi CSDL SQLite.
4. 💾 Cơ sở dữ liệu SQLite (DatabaseHelper.java)
Lưu trữ dữ liệu bền vững offline trên thiết bị.
Tự động tính toán Số Dư Hiện Tại = Tổng Thu - Tổng Chi bằng các câu lệnh SQL SUM(amount).
📂 CẤU TRÚC THƯ MỤC DỰ ÁN
text

25TH2532_QuanLyChiTieuCaNhan/
├── app/src/main/
│   ├── java/com/example/a25th2532_quanlychitieucanhan/
│   │   ├── Transaction.java               # Model biểu diễn khoản thu/chi
│   │   ├── DatabaseHelper.java            # Quản lý CSDL SQLite (Thêm, Xóa, Sửa, Thống kê)
│   │   ├── TransactionAdapter.java        # Adapter định dạng tiền VNĐ & tô màu Thu/Chi
│   │   ├── MainActivity.java              # Controller Màn hình chính
│   │   └── AddEditTransactionActivity.java # Controller Màn hình Thêm/Sửa
│   ├── res/layout/
│   │   ├── activity_main.xml              # Layout Màn hình chính
│   │   ├── activity_add_edit_transaction.xml # Layout Màn hình Thêm/Sửa
│   │   └── item_transaction.xml           # Layout mẫu từng dòng danh sách
│   └── AndroidManifest.xml               # Khai báo hệ thống Android
