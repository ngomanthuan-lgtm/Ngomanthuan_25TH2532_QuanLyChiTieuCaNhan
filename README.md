💸 ỨNG DỤNG QUẢN LÝ CHI TIÊU CÁ NHÂN (EXPENSE MANAGEMENT APP)
🎓 ĐỒ ÁN CUỐI KỲ MÔN LẬP TRÌNH THIẾT BỊ DI ĐỘNG (ANDROID)
📌 THÔNG TIN ĐỒ ÁN
Sinh viên thực hiện: Ngô Mẫn Thuận
Mã số sinh viên: 25TH2532
Lớp: CC25CTH
Giảng viên hướng dẫn: Mai Cường Thọ
Trường: Đại học Nha Trang (NTU)
Nền tảng phát triển: Android Studio, Ngôn ngữ Java, Cơ sở dữ liệu SQLite
📖 CHƯƠNG 1: GIỚI THIỆU & MỤC TIÊU ĐỀ TÀI
Ứng dụng "Quản Lý Chi Tiêu Cá Nhân" giúp người dùng dễ dàng theo dõi các khoản thu nhập (lương, thưởng...) và chi tiêu (ăn uống, mua sắm, học tập...) hàng ngày.

Các mục tiêu chính:
Quản lý Thu / Chi (CRUD): Thêm, xem, sửa, xóa khoản thu chi nhanh chóng.
Tự động tính số dư: Số Dư Hiện Tại = Tổng Thu - Tổng Chi.
Lưu trữ CSDL SQLite: Lưu dữ liệu bền vững offline ngay trên thiết bị di động.
Phân biệt màu sắc: Khoản Thu nhập hiển thị màu Xanh lá (+), Khoản Chi tiêu hiển thị màu Đỏ (-).
🗄️ CHƯƠNG 2: THIẾT KẾ CƠ SỞ DỮ LIỆU SQLITE (QuanLyChiTieu_25TH2532.db)
Bảng transactions lưu trữ dữ liệu thu chi bao gồm 7 trường:

Tên Cột	Kiểu Dữ Liệu	Ràng buộc	Mô tả
id	INTEGER	PRIMARY KEY AUTOINCREMENT	Mã giao dịch tự tăng
title	TEXT	NOT NULL	Tên khoản thu/chi
amount	REAL	NOT NULL	Số tiền giao dịch
category	TEXT		Danh mục (Ăn uống, Lương...)
type	TEXT	NOT NULL	Loại giao dịch ("THU" / "CHI")
date	TEXT	NOT NULL	Ngày giao dịch (dd/MM/yyyy)
note	TEXT		Ghi chú thêm
📸 CHƯƠNG 3: HÌNH ẢNH GIAO DIỆN & GIẢI THÍCH CHỨC NĂNG
1. 📱 Màn hình chính Danh sách Chi tiêu & Thống kê Số dư (activity_main.xml)
<img width="278" height="431" alt="Hình 1" src="https://github.com/user-attachments/assets/aee9fb60-1258-410b-8214-effbb2827da1" />


Chi tiết các thành phần & chức năng:

Header: Nền xanh #1E88E5, hiển thị tiêu đề QUẢN LÝ CHI TIÊU CÁ NHÂN và SV: Ngô Mẫn Thuận | MSSV: 25TH2532.
Thẻ CardView: Hiển thị Số Dư Hiện Tại, Tổng Thu (Màu xanh lá) và Tổng Chi (Màu đỏ).
Danh sách ListView: Sử dụng TransactionAdapter tải dữ liệu từ CSDL SQLite.
Nút Thêm (+) (FloatingActionButton): Bấm để chuyển sang màn hình Thêm giao dịch mới.
Click item: Mở màn hình Sửa giao dịch.
Long-click item: Hiển thị Hộp thoại AlertDialog xác nhận Xóa giao dịch.
2. ➕ Màn hình Thêm & Chỉnh sửa giao dịch (activity_add_edit_transaction.xml)
<img width="308" height="429" alt="Hình 2" src="https://github.com/user-attachments/assets/024fee97-973d-4a40-86b5-c8d81cc1c761" />


Chi tiết các thành phần & chức năng:

RadioGroup: Nút chọn Chi Tiêu (-) (Màu đỏ) và Thu Nhập (+) (Màu xanh lá).
EditText: Nhập Tên khoản (edtTitle), Số tiền (edtAmount), Ghi chú (edtNote).
Spinner: Chọn Danh mục (Ăn uống, Lương, Mua sắm, Học tập...).
DatePickerDialog: Nhấp vào edtDate để chọn ngày dạng dd/MM/yyyy.
Nút LƯU GIAO DỊCH (btnSave): Kiểm tra dữ liệu hợp lệ và lưu vào SQLite CSDL.
3. 🧩 Giao diện Khung mẫu từng dòng giao dịch (item_transaction.xml)
<img width="281" height="486" alt="Hình 3" src="https://github.com/user-attachments/assets/b6870c85-ee15-4daf-8794-0792b2dcc22d" />


Chi tiết các thành phần & chức năng:

Tên khoản & Danh mục: Hiển thị tvItemTitle (In đậm) và tvItemCategoryDate (Danh mục | Ngày).
Số tiền: Định dạng VNĐ #,### đ qua DecimalFormat, tự động tô màu xanh lá (Thu) hoặc màu đỏ (Chi).
💻 CHƯƠNG 4: MÃ NGUỒN CỐT LÕI (CORE SOURCE CODE)
1. File DatabaseHelper.java (Quản lý CSDL SQLite)
Thực hiện câu lệnh SQL CREATE TABLE, INSERT, UPDATE, DELETE.
Tính tổng bằng câu lệnh SQL: SELECT SUM(amount) FROM transactions WHERE type = 'THU'.
2. File TransactionAdapter.java (Format hiển thị & Màu sắc)
Sử dụng DecimalFormat("#,### đ") định dạng tiền tệ.
Gán màu #2E7D32 cho Thu nhập và #C62828 cho Chi tiêu trong hàm getView().
3. File MainActivity.java & AddEditTransactionActivity.java
Xử lý chuyển màn hình qua Intent, bắt sự kiện click và tương tác dữ liệu.
