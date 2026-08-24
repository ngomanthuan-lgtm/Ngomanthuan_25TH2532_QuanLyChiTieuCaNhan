<h1>💸 ỨNG DỤNG QUẢN LÝ CHI TIÊU CÁ NHÂN (EXPENSE MANAGEMENT APP)</h1>
<h3>🎓 ĐỒ ÁN CUỐI KỲ MÔN LẬP TRÌNH THIẾT BỊ DI ĐỘNG (ANDROID)</h3>

<hr>

<h2>📌 THÔNG TIN ĐỒ ÁN</h2>
<ul>
  <li><b>Sinh viên thực hiện:</b> Ngô Mẫn Thuận</li>
  <li><b>Mã số sinh viên:</b> 25TH2532</li>
  <li><b>Lớp:</b> CC25CTH</li>
  <li><b>Giảng viên hướng dẫn:</b> Mai Cường Thọ</li>
  <li><b>Trường:</b> Đại học Nha Trang (NTU)</li>
  <li><b>Nền tảng phát triển:</b> Android Studio, Ngôn ngữ Java, Cơ sở dữ liệu SQLite</li>
</ul>

<hr>

<h2>📖 CHƯƠNG 1: GIỚI THIỆU & MỤC TIÊU ĐỀ TÀI</h2>

<p>Ứng dụng <b>"Quản Lý Chi Tiêu Cá Nhân"</b> được xây dựng trên hệ điều hành Android giúp người dùng theo dõi các khoản thu nhập (lương, thưởng...) và chi tiêu (ăn uống, mua sắm, học tập...) hàng ngày một cách trực quan, nhanh chóng và chính xác.</p>

<h3>Mục tiêu chính:</h3>
<ul>
  <li><b>Quản lý Thu / Chi (CRUD):</b> Thêm, xem, sửa, xóa khoản thu chi nhanh chóng.</li>
  <li><b>Tự động tính số dư:</b> Số Dư Hiện Tại = Tổng Thu - Tổng Chi.</li>
  <li><b>Lưu trữ CSDL SQLite:</b> Lưu dữ liệu bền vững offline ngay trên thiết bị di động.</li>
  <li><b>Phân biệt màu sắc:</b> Khoản Thu nhập hiển thị màu Xanh lá (+), Khoản Chi tiêu hiển thị màu Đỏ (-).</li>
</ul>

<hr>

<h2>🗄️ CHƯƠNG 2: THIẾT KẾ CƠ SỞ DỮ LIỆU SQLITE (QuanLyChiTieu_25TH2532.db)</h2>

<p>Bảng <code>transactions</code> lưu trữ dữ liệu thu chi bao gồm 7 trường:</p>

<table border="1" width="100%" cellpadding="8" style="border-collapse: collapse;">
  <thead>
    <tr bgcolor="#E3F2FD">
      <th>Tên Cột</th>
      <th>Kiểu Dữ Liệu</th>
      <th>Ràng buộc</th>
      <th>Mô tả</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><b>id</b></td>
      <td>INTEGER</td>
      <td>PRIMARY KEY AUTOINCREMENT</td>
      <td>Mã tự tăng</td>
    </tr>
    <tr>
      <td><b>title</b></td>
      <td>TEXT</td>
      <td>NOT NULL</td>
      <td>Tên khoản thu/chi</td>
    </tr>
    <tr>
      <td><b>amount</b></td>
      <td>REAL</td>
      <td>NOT NULL</td>
      <td>Số tiền giao dịch</td>
    </tr>
    <tr>
      <td><b>category</b></td>
      <td>TEXT</td>
      <td>-</td>
      <td>Danh mục (Ăn uống, Lương...)</td>
    </tr>
    <tr>
      <td><b>type</b></td>
      <td>TEXT</td>
      <td>NOT NULL</td>
      <td>Loại ("THU" / "CHI")</td>
    </tr>
    <tr>
      <td><b>date</b></td>
      <td>TEXT</td>
      <td>NOT NULL</td>
      <td>Ngày (dd/MM/yyyy)</td>
    </tr>
    <tr>
      <td><b>note</b></td>
      <td>TEXT</td>
      <td>-</td>
      <td>Ghi chú thêm</td>
    </tr>
  </tbody>
</table>

<hr>

<h2>📸 CHƯƠNG 3: HÌNH ẢNH GIAO DIỆN & GIẢI THÍCH CHỨC NĂNG</h2>

<h3>1. 📱 Màn hình chính Danh sách Chi tiêu & Thống kê Số dư (activity_main.xml)</h3>

<p><i><img width="278" height="431" alt="Hình 1" src="https://github.com/user-attachments/assets/4bf22c9c-1c74-44c6-a381-aedd2b8eafd2" />
</i></p>

<p><b>Chi tiết các thành phần & chức năng:</b></p>
<ul>
  <li><b>Header:</b> Nền xanh #1E88E5, hiển thị tiêu đề QUẢN LÝ CHI TIÊU CÁ NHÂN và SV: Ngô Mẫn Thuận | MSSV: 25TH2532.</li>
  <li><b>Thẻ CardView:</b> Hiển thị Số Dư Hiện Tại, Tổng Thu (Màu xanh lá) và Tổng Chi (Màu đỏ).</li>
  <li><b>Danh sách ListView:</b> Sử dụng TransactionAdapter tải dữ liệu từ CSDL SQLite.</li>
  <li><b>Nút Thêm (+) (FloatingActionButton):</b> Bấm để chuyển sang màn hình Thêm giao dịch mới.</li>
  <li><b>Click item:</b> Mở màn hình Sửa giao dịch.</li>
  <li><b>Long-click item:</b> Hiển thị Hộp thoại AlertDialog xác nhận Xóa giao dịch.</li>
</ul>

<br>

<h3>2. ➕ Màn hình Thêm & Chỉnh sửa giao dịch (activity_add_edit_transaction.xml)</h3>

<p><i><img width="308" height="429" alt="Hình 2" src="https://github.com/user-attachments/assets/4b4a26c9-3114-437a-9cea-b11d15a9e6f4" />
</i></p>

<p><b>Chi tiết các thành phần & chức năng:</b></p>
<ul>
  <li><b>RadioGroup:</b> Nút chọn Chi Tiêu (-) (Màu đỏ) và Thu Nhập (+) (Màu xanh lá).</li>
  <li><b>EditText:</b> Nhập Tên khoản (edtTitle), Số tiền (edtAmount), Ghi chú (edtNote).</li>
  <li><b>Spinner:</b> Chọn Danh mục (Ăn uống, Lương, Mua sắm, Học tập...).</li>
  <li><b>DatePickerDialog:</b> Nhấp vào edtDate để chọn ngày dạng dd/MM/yyyy.</li>
  <li><b>Nút LƯU GIAO DỊCH (btnSave):</b> Kiểm tra dữ liệu hợp lệ và lưu vào SQLite CSDL.</li>
</ul>

<br>

<h3>3. 🧩 Giao diện Khung mẫu từng dòng giao dịch (item_transaction.xml)</h3>

<p><i><img width="281" height="486" alt="Hình 3" src="https://github.com/user-attachments/assets/dd9834ce-8242-42e9-acb3-8a3da60f8ab2" />
</i></p>

<p><b>Chi tiết các thành phần & chức năng:</b></p>
<ul>
  <li><b>Tên khoản & Danh mục:</b> Hiển thị tvItemTitle (In đậm) và tvItemCategoryDate (Danh mục | Ngày).</li>
  <li><b>Số tiền:</b> Định dạng VNĐ #,### đ qua DecimalFormat, tự động tô màu xanh lá (Thu) hoặc màu đỏ (Chi).</li>
</ul>

<hr>

<h2>💻 CHƯƠNG 4: MÃ NGUỒN CỐT LÕI (CORE SOURCE CODE)</h2>

<ul>
  <li><b>1. File DatabaseHelper.java (Quản lý CSDL SQLite):</b> Thực hiện các câu lệnh SQL CREATE TABLE, INSERT, UPDATE, DELETE. Tính tổng bằng câu lệnh SQL SUM: <code>SELECT SUM(amount) FROM transactions WHERE type = 'THU'</code>.</li>
  <li><b>2. File TransactionAdapter.java (Format hiển thị & Màu sắc):</b> Sử dụng <code>DecimalFormat("#,### đ")</code> định dạng tiền tệ. Gán màu #2E7D32 cho Thu nhập và #C62828 cho Chi tiêu trong hàm <code>getView()</code>.</li>
  <li><b>3. File MainActivity.java & AddEditTransactionActivity.java:</b> Xử lý chuyển màn hình qua Intent, bắt sự kiện click và tương tác dữ liệu.</li>
</ul>

<hr>

<h2>🚀 CHƯƠNG 5: HƯỚNG DẪN CÀI ĐẶT & CHẠY DỰ ÁN</h2>

<ol>
  <li><b>Clone dự án từ GitHub:</b><br>
      <code>git clone https://github.com/ngomanthuan-lgtm/Ngomanthuan_25TH2532_QuanLyChiTieuCaNhan.git</code>
  </li>
  <li><b>Mở dự án:</b> Trong Android Studio chọn File ➔ Open... ➔ Chọn thư mục dự án.</li>
  <li><b>Chạy ứng dụng:</b> Chọn máy ảo Pixel hoặc thiết bị thật và nhấn nút Run ▶️ (Shift + F10).</li>
</ol>

<hr>

<p align="center"><i>Đồ án Bài tập lớn môn Lập trình thiết bị di động được thực hiện bởi sinh viên Ngô Mẫn Thuận - MSSV: 25TH2532.</i></p>
