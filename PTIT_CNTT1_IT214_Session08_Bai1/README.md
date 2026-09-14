# Session 08 - Bài 1: Báo Cáo Tổng Hợp & Đánh Giá Tối Ưu Hóa Mã Nguồn Mini Project

## 📌 Tổng Quan Dự Án Mini Project (VietMart Platform)
Dự án Mini Project Microservices tổng hợp các thành phần cốt lõi của hệ thống thương mại điện tử / ngân hàng số VietMart:
1. **Config Server Service (`config-server`)**: Quản lý tập trung file cấu hình `.yml` cho tất cả microservices.
2. **Eureka Discovery Server Cluster (`discovery-server`)**: Đăng ký và tra cứu vị trí IP/Port động của các instance.
3. **API Gateway (`api-gateway` Port 8222)**: Điểm tiếp nhận request duy nhất, định tuyến tự động qua Load Balancer (`lb://`).
4. **Core Microservices**: `customer-service`, `account-service`, `transaction-service`, `product-service`, `inventory-service`.

---

## 🛠️ Danh Sách Các Cải Tiến & Sửa Lỗi Đã Tái Cấu Trúc (Refactoring Log)

1. **Sửa Lỗi Route Hardcode IP Trên API Gateway**:
   - Chuyển toàn bộ `uri: http://<hostname>` thành `uri: lb://<service-name>` để kích hoạt Spring Cloud LoadBalancer.
2. **Cô Lập Scope Thuật Toán Load Balancer**:
   - Loại bỏ `@Configuration` thừa trên các class cấu hình custom load balancer để tránh Scope Pollution tới các service khác.
3. **Phòng Chống Cascading Failure Trong RestTemplate**:
   - Thiết lập `connectTimeout = 2s` và `readTimeout = 3s` cho `RestTemplateBuilder`.
   - Bắt `ResourceAccessException` để trả về Fallback DTO ngay lập tức.
4. **Tương Thích Ngược Hợp Đồng API Với `@JsonAlias`**:
   - Thêm `@JsonAlias({"name", "productName"})` giúp DTO tương thích mượt mà cả 2 phiên bản payload v1 và v2.

---

## 🚀 Kiểm Thử
```bash
./gradlew test
```
