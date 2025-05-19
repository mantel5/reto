USE reto;
-- Insertar datos en la tabla clientes
INSERT INTO clientes (nombre, email, telefono, contrasena) VALUES
('John Perez', 'john.perez@email.com', '123456789', 'hashed_password_1'),
('Anna Gomez', 'anna.gomez@email.com', '987654321', 'hashed_password_2'),
('Charles Martin', 'charles.martin@email.com', '1122334455', 'hashed_password_3');

-- Insertar datos en la tabla direccion_envio
INSERT INTO direccion_envio (id_cliente, calle, ciudad, codigo_postal, pais) VALUES
(1, '123 Fake Street', 'Madrid', '28001', 'Spain'),
(2, '456 Liberty Avenue', 'Barcelona', '08001', 'Spain'),
(3, '789 Royal Street', 'Valencia', '46001', 'Spain');

-- Insertar datos en la tabla hamburgueserias
INSERT INTO hamburgueserias (nombre, direccion, codigo_postal) VALUES
('The Big Burger', '123 Main Street', '28001'),
('Burger King', '456 King Avenue', '08001'),
('McDonalds', '789 Main Square', '46001'),
('Five Guys', '101 Peace Avenue', '28002'),
('Shake Shack', '202 Sun Street', '08002');

-- Insertar datos en la tabla productos
INSERT INTO productos (nombre, descripcion, precio, stock, categoria, imagen) VALUES
('Classic', 'Beef burger with lettuce, tomato, and cheese.', 11, 100, 'hamburguesa','https://images.unsplash.com/photo-1568901346375-23c9450c58cd?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'),
('Double Cheese', 'Double beef, double cheddar cheese, caramelized onions, and BBQ sauce.', 14, 50, 'hamburguesa','https://images.unsplash.com/photo-1553979459-d2229ba7433b?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'),
('Bacon Crunch', 'Beef, cheese, crispy bacon, onion rings, and chipotle sauce.', 15, 50, 'hamburguesa','https://images.unsplash.com/photo-1561758033-d89a9ad46330?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'),
('Veggie', 'Chickpea burger, vegan cheese, avocado, and fresh vegetables.', 16, 50, 'hamburguesa','https://www.flora.es/-/media/Project/Upfield/Brands/Becel-NL/Flora-ES/Assets/Recetas/7c0e514e-2b78-48d8-a344-89fd5a74fa43.jpg?rev=e489cf18149d4a1093a14b782cf66102&w=900'),
('Spicy', 'Beef, pepper jack cheese, jalapeños, spicy sauce, and chipotle mayo.', 15, 50, 'hamburguesa','https://images.unsplash.com/photo-1530554764233-e79e16c91d08?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'),
('BBQ', 'Beef, cheddar cheese, crispy onions, bacon, and lots of BBQ sauce.', 12, 50, 'hamburguesa','https://images.unsplash.com/photo-1586190848861-99aa4a171e90?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=80'),
('Cheesy Nachos', 'Enjoy delicious nachos with melted cheese and spicy sauce.', 6, 50, 'entrante','https://www.bekiacocina.com/images/cocina/0000/607-h.jpg'),
('Chicken Wings', 'Crispy wings served with your favorite sauce: BBQ, spicy, or honey mustard.', 8, 50, 'entrante','https://i.ytimg.com/vi/24GYkRzpuxs/maxresdefault.jpg'),
('Fried Mozzarella', 'Breaded and fried mozzarella cheese served with marinara sauce.', 7, 50, 'entrante','https://previews.123rf.com/images/korzeniewskidaniel/korzeniewskidaniel0906/korzeniewskidaniel090600086/5076062-plato-de-queso-mozzarella-frito-con-salsa-marinara-el-perejil-y-el-queso-mozzarella-de-fusi%C3%B3n-en-la.jpg'),
('Coca Cola', 'Classic, refreshing, and delicious soda.', 3, 100, 'bebida','https://www.cocacolaep.com/assets/legacy-assets/Spain/Blog-Rojo-y-en-Botella/2023/MARZO/5-CURIOSIDADES-CONTOUR/Coca-Cola-Contour-1210x1080.jpg'),
('Sprite', 'Lime-lemon soda, fresh and light.', 3, 100, 'bebida','https://lacriaturacreativa.com/wp-content/uploads/2022/05/sprite-nueva-imagen00.png'),
('Water', 'Fresh and purified water.', 2, 200, 'bebida','https://shop.veritas.es/documents/10180/23257/19596_G.jpg'),
('Fanta', 'Orange soda, fruity and refreshing.', 3, 100, 'bebida','https://www.coca-cola.com/content/dam/onexp/es/es/brand/fanta-v2/es_fanta_naranja_750x750.jpg');


-- Insertar datos en la tabla carritos
INSERT INTO carritos (id_cliente, id_direccion_envio, fecha_creacion, estado) VALUES
(1, 1, '2025-04-09 12:00:00', 'Active'),
(2, 2, '2025-04-09 12:05:00', 'Abandoned'),
(3, 3, '2025-04-09 12:10:00', 'Completed');

-- Insertar datos en la tabla detalle_carrito
INSERT INTO detalle_carrito (id_carrito, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 2, 5.99),
(1, 2, 1, 6.99),
(2, 1, 1, 5.99),
(3, 3, 2, 2.50);

-- Insertar datos en la tabla valoraciones
INSERT INTO valoraciones (id_cliente, id_producto, puntuacion, comentario) VALUES
(1, 1, 5, 'Excellent burger, very tasty!'),
(2, 2, 4, 'Good burger, but could use more sauce.'),
(3, 3, 3, 'The fries are average.');

-- Insertar datos en la tabla ofertas
INSERT INTO ofertas (descripcion, descuento, fecha_inicio, fecha_fin) VALUES
('25% discount on the entire order', 25.00, '2025-04-01 00:00:00', '2025-04-30 23:59:59');

-- Insertar datos en la tabla pedidos
INSERT INTO pedidos (id_cliente, id_direccion_envio, id_oferta, fecha_pedido, estado) VALUES
(1, 1, 1, '2025-04-09 12:00:00', 'Pending'),
(2, 2, NULL, '2025-04-09 12:05:00', 'In Process'),
(3, 3, 1, '2025-04-09 12:10:00', 'Completed');

-- Insertar datos en la tabla detalle_pedido
INSERT INTO detalle_pedido (id_pedido, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 2, 5.99),
(1, 2, 1, 6.99),
(2, 1, 1, 5.99),
(3, 3, 2, 2.50);

-- Insertar datos en la tabla pagos
INSERT INTO pagos (id_cliente, id_pedido, monto, metodo_pago) VALUES
(1, 1, 18.97, 'Card'),
(2, 2, 5.99, 'Cash'),
(3, 3, 7.50, 'PayPal');

-- Insertar datos en la tabla trabajadores
INSERT INTO trabajadores (nombre, email, telefono, puesto, id_hamburgueseria) VALUES
('Luis Garcia', 'luis.garcia@email.com', '666777888', 'Cook', 1),
('Maria Lopez', 'maria.lopez@email.com', '555666777', 'Waitress', 2),
('Peter Sanchez', 'peter.sanchez@email.com', '444555666', 'Cashier', 3),
('Elena Ruiz', 'elena.ruiz@email.com', '333444555', 'Manager', 4),
('Javier Martin', 'javier.martin@email.com', '222333444', 'Cook', 5);