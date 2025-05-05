-- 1. Liệt kê tất cả sách và tên nhà xuất bản của các quyển sách, sao cho quyển sách đó có ít nhất một hóa đơn mượn sách.

SELECT b.Title AS Book_Title, p.Name AS Publisher_Name
FROM Book b
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
WHERE b.Book_Id IN (SELECT Book_Id FROM Book_Invoice);

-- 2. Tính tổng số quyển sách mà mỗi nhà xuất bản đã xuất bản.

SELECT p.Name AS Publisher_Name, COUNT(b.Book_Id) AS Total_Books_Published
FROM Publisher p
JOIN Book b ON p.Pub_Id = b.Pub_Id
GROUP BY p.Name;

-- 3. Liệt kê tên sách và tên nhà xuất bản của sách có giá lớn hơn giá trung bình của tất cả quyển sách.

SELECT b.Title AS Book_Title, p.Name AS Publisher_Name
FROM Book b
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
WHERE b.Price > (SELECT AVG(Price) FROM Book);

-- 4. Liệt kê thông tin của tất cả các thành viên và số lượng quyển sách mà họ đã mượn

SELECT m.Surname, m.Name, COUNT(bi.Book_Id) AS Total_Books_Borrowed
FROM Member m
LEFT JOIN Book_Invoice bi ON m.CardNo = bi.CardNo
GROUP BY m.CardNo, m.Surname, m.Name;

-- 5. Liệt kê tên sách và tên nhà xuất bản của quyển sách có giá cao nhất và giá thấp nhất.

SELECT b.Title AS Book_Title, p.Name AS Publisher_Name, b.Price AS Book_Price
FROM Book b
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
WHERE b.Price = (SELECT MAX(Price) FROM Book)
   OR b.Price = (SELECT MIN(Price) FROM Book);


-- 6. Đếm tổng số các quyển sách mà các nhà xuất bản đã xuất bản

SELECT p.Name AS Publisher_Name, COUNT(b.Book_Id) AS Total_Books
FROM Publisher p
LEFT JOIN Book b ON p.Pub_Id = b.Pub_Id
GROUP BY p.Pub_Id, p.Name;

-- 7. Liệt kê tên sách và tên nhà xuất bản của sách, sao cho sách đó có ít nhất một hóa đơn mượn và hóa đơn đó không bị trễ hạn.

SELECT DISTINCT b.Title, p.Name AS Publisher_Name
FROM Book b
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
JOIN Book_Invoice bi ON b.Book_Id = bi.Book_Id
WHERE bi.Date_Out < bi.Due_Date;

-- 8. Liệt kê tất cả thông tin của các thành viên mà đã mượn sách và số lượng sách mà họ đã mượn, sắp xếp theo số lượng sách giảm dần.

SELECT m.*, COUNT(bi.Book_Id) AS Total_Books_Borrowed
FROM Member m
JOIN Book_Invoice bi ON m.CardNo = bi.CardNo
GROUP BY m.CardNo
ORDER BY Total_Books_Borrowed DESC;

-- 9. Tính tổng số quyển sách mà mỗi nhà xuất bản đã xuất bản, chỉ bao gồm những nhà xuất bản đã xuất bản ít nhất hai sách.

SELECT p.Name AS Publisher_Name, COUNT(b.Book_Id) AS Total_Books
FROM Publisher p
JOIN Book b ON p.Pub_Id = b.Pub_Id
GROUP BY p.Pub_Id, p.Name
HAVING COUNT(b.Book_Id) >= 2;

-- 10. Liệt kê tất cả thông tin của các thành viên mà đã mượn sách loại 'crime story' và số lượng sách mà họ đã mượn ít nhất là 1 quyển.

SELECT m.*, COUNT(b.Book_Id) AS Crime_Story_Borrowed
FROM Member m
JOIN Book_Invoice bi ON m.CardNo = bi.CardNo
JOIN Book b ON bi.Book_Id = b.Book_Id
WHERE b.Type = 'crime story'
GROUP BY m.CardNo
HAVING COUNT(b.Book_Id) >= 1;

-- 11. Liệt kê tên sách và ngày mượn của sách có hóa đơn mượn nhưng chưa được trả và số lượng ngày quá hạn (số ngày giữa Due_Date và ngày hiện tại).

SELECT b.Title, bi.Date_Out, DATEDIFF(NOW(), bi.Due_Date) AS Overdue_Days
FROM Book_Invoice bi
JOIN Book b ON bi.Book_Id = b.Book_Id
WHERE bi.Due_Date < NOW();

-- 12. Liệt kê tên sách và tên nhà xuất bản của sách có hóa đơn mượn nhưng chưa được trả và số lượng ngày quá hạn lớn hơn 7.

SELECT b.Title, p.Name AS Publisher_Name, DATEDIFF(NOW(), bi.Due_Date) AS Overdue_Days
FROM Book_Invoice bi
JOIN Book b ON bi.Book_Id = b.Book_Id
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
WHERE bi.Due_Date < NOW() AND DATEDIFF(NOW(), bi.Due_Date) > 7;

-- 13. Đếm xem ngày hôm nay mỗi nhân viên có bao nhiêu hóa đơn.

SELECT e.Name, e.Surname, COUNT(bi.Invoice_No) AS Today_Invoices
FROM Employee e
LEFT JOIN Book_Invoice bi ON e.Emp_Id = bi.Emp_Id AND DATE(bi.Date_Out) = CURDATE()
GROUP BY e.Emp_Id, e.Name, e.Surname;

-- 14. Liệt kê tên sách và số lượng quyển sách mà sách đó có ít nhất một hóa đơn mượn và được xuất bản trong thành phố 'Hanoi'.

SELECT b.Title, COUNT(bi.Book_Id) AS Borrowed_Count
FROM Book b
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
JOIN Book_Invoice bi ON b.Book_Id = bi.Book_Id
WHERE p.City = 'Hanoi'
GROUP BY b.Book_Id, b.Title;

-- 15. Liệt kê tên sách và giá của quyển sách có giá thấp hơn giá trung bình của tất cả quyển sách và được xuất bản trong thành phố 'Hanoi'.

SELECT b.Title, b.Price
FROM Book b
JOIN Publisher p ON b.Pub_Id = p.Pub_Id
WHERE b.Price < (SELECT AVG(Price) FROM Book)
  AND p.City = 'Hanoi';