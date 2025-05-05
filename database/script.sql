-- 1. Tính tổng số tiền các sản phẩm user đã thêm vào giỏ hàng.
SELECT 
    u.id AS user_id,
    u.fullname,
    SUM(ci.quantity * p.price) AS total_cart_value
FROM users u
JOIN carts c ON u.id = c.user_id
JOIN cart_items ci ON c.id = ci.cart_id
JOIN products p ON ci.product_id = p.id
GROUP BY u.id, u.fullname;

-- 2. Lấy ra danh sách người dùng đã từng có đơn hàng trên 50 nghìn.
SELECT DISTINCT
    u.id,
    u.fullname,
    o.total_amount
FROM users u
JOIN orders o ON u.id = o.user_id
WHERE o.total_amount > 50000;

-- 3. Lấy ra danh sách các sản phẩm đã hết hàng ở trong kho.
SELECT 
    id,
    name,
    stock
FROM products
WHERE stock = 0;

-- 4. Lấy ra danh sách người dùng và số lượng mặt hàng người dùng đó đang có trong giỏ hàng.
SELECT 
    u.id AS user_id,
    u.fullname,
    COUNT(DISTINCT ci.product_id) AS product_count
FROM users u
JOIN carts c ON u.id = c.user_id
JOIN cart_items ci ON c.id = ci.cart_id
GROUP BY u.id, u.fullname;

-- 5. Tính tổng số tiền lãi sẽ thu được nếu như bán hết các sản phẩm còn lại.
SELECT 
    SUM((p.price - p.original_price) * p.stock) AS total_profit
FROM products p;