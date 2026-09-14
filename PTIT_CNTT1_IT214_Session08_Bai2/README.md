# Session 08 - Bài 2: Tích Hợp Dynamic API Gateway Filters & Loan Service Đa Feign Client

## 📌 Tổng Quan & Thiết Kế Kiến Trúc
1. **API Gateway Filters (`RequestLoggingGlobalFilter`)**:
   - Tự động ghi log chi tiết khi request đi qua Gateway (Pre-Filter) và bổ sung header `X-Gateway-Latency` tính toán thời gian xử lý chính xác tính bằng millisecond (Post-Filter).
2. **Loan Microservice (`loan-service`)**:
   - Xây dựng API duyệt khoản vay `POST /api/loans/apply`.
   - Kết nối song song với 2 dịch vụ độc lập qua Feign: `CustomerServiceClient` (kiểm tra Điểm Tín Dụng `creditScore >= 600`) và `AccountServiceClient` (kiểm tra Trạng thái Tài khoản `status == ACTIVE`).

---

## 🚀 Kiểm Thử
```bash
./gradlew test
```
