

  // Funcionalidad de pestañas
  const tabBtns = document.querySelectorAll('.tab-btn');
  const tabContents = document.querySelectorAll('.tab-content');
 
  tabBtns.forEach(btn => {
      btn.addEventListener('click', () => {
          const tabId = btn.getAttribute('data-tab');
         
          // Remover active de todos
          tabBtns.forEach(b => b.classList.remove('active'));
          tabContents.forEach(c => c.classList.remove('active'));
         
          // Agregar active al seleccionado
          btn.classList.add('active');
          document.getElementById(tabId).classList.add('active');
      });
  });
 
  // Manejo de formularios (ejemplo básico)
  document.getElementById('loginForm').addEventListener('submit', (e) => {
      e.preventDefault();
      alert('Successful login ');
      modal.style.display = 'none';
      document.body.style.overflow = 'auto';
  });
 
  document.getElementById('registerForm').addEventListener('submit', (e) => {
      e.preventDefault();
      alert('Successful registration');
      // Cambiar a pestaña de login después de registrar
      tabBtns[0].click();
  });




document.addEventListener('DOMContentLoaded', function() {
    // Variables del carrito
    let cart = [];
    const cartItemsEl = document.getElementById('cart-items');
    const cartTotalEl = document.getElementById('cart-total');
    const emptyCartMsg = document.getElementById('empty-cart-message');
    const checkoutBtn = document.getElementById('checkout-btn');
    const clearCartBtn = document.getElementById('clear-cart');
   
    // Configuración de productos y promociones
    const products = {
        "1": { name: "Classic", price: 10.99 },
        "2": { name: "Double Cheese", price: 13.99 },
        "3": { name: "Bacon Crunch", price: 14.99 },
        "4": { name: "Veggie", price: 16 },
        "5": { name: "Spicy", price: 14.99 },
        "6": { name: "BBQ", price: 12 },
        "7": { name: "Coca-cola", price: 3 },
        "8": { name: "Sprite", price: 3 },
        "9": { name: "Water", price: 2 },
        "10": { name: "Fanta", price: 3 }
    };












   // Obtener los elementos del DOM
    const postulateBtn = document.getElementById('postulate-btn');
    const modal = document.getElementById('postulate-modal');
    const closeBtn = document.getElementById('close-btn');




     // Mostrar el modal cuando se haga clic en "Postúlate ahora"
       postulateBtn.onclick = function() {
     modal.style.display = "block";
}




     // Ocultar el modal cuando se haga clic en la "X"
     closeBtn.onclick = function() {
     modal.style.display = "none";
}




     // Ocultar el modal si el usuario hace clic fuera del contenido del modal
          window.onclick = function(event) {
     if (event.target === modal) {
        modal.style.display = "none";
    }
}




     // Puedes manejar el envío del formulario aquí si deseas
     document.getElementById('postulate-form').onsubmit = function(event) {
     event.preventDefault(); // Prevenir el envío normal del formulario
     alert('Form submitted successfully');
     modal.style.display = "none"; // Cerrar el modal después de enviar
}
    const promotions = {
        "combo-familiar": {
            name: "Family offer",
            items: [
                { id: "1", quantity: 2 },  // 2 hamburguesas clásicas
                { id: "2", quantity: 2 },  // 2 hamburguesas doble queso
                { id: "8", quantity: 4 },  // 4 bebidas
                { id: "7", quantity: 1 }   // 1 papas gigantes
            ],
            originalPrice: 70,
            discountPrice: 50,
            description: "4 burgers + 4 drinks + giant fries"
        },
        "martes-hamburguesa": {
            name: "Burger Tuesday",
            items: [
                { id: "1", quantity: 2 }  // 2 hamburguesas clásicas
            ],
            originalPrice: 24,
            discountPrice: 12,
            description: "2 burgers for the price of 1"
        },
        "happy-hour": {
            name: "Happy Hour",
            items: [
                { id: "9", quantity: 1 },  // Cerveza
                { id: "10", quantity: 1 }  // Refresco
            ],
            originalPrice: 3,
            discountPrice: 2.4,
            description: "20% discount on drinks"
        }
    };




    // Cargar carrito desde localStorage
    if (localStorage.getItem('tlb-cart')) {
        try {
            cart = JSON.parse(localStorage.getItem('tlb-cart'));
            updateCart();
        } catch (e) {
            console.error("Error loading cart:", e);
            localStorage.removeItem('tlb-cart');
            cart = [];
        }
    }
   
    // Añadir al carrito (productos individuales)
    document.querySelectorAll('.add-to-cart').forEach(button => {
        button.addEventListener('click', function() {
            const id = this.getAttribute('data-id');
            const name = this.getAttribute('data-name');
            const price = parseFloat(this.getAttribute('data-price'));
           
            const existingItem = cart.find(item => item.id === id);
           
            if (existingItem) {
                existingItem.quantity += 1;
            } else {
                cart.push({
                    id,
                    name,
                    price,
                    quantity: 1
                });
            }
           
            updateCart();
            saveCartToLocalStorage();
            showNotification(`✅ ${name} added to cart`);
        });
    });
   
    // Añadir promoción al carrito
    document.querySelectorAll('.add-promo').forEach(button => {
        button.addEventListener('click', function(e) {
            e.preventDefault();
            const promoId = this.getAttribute('data-promo');
            addPromotionToCart(promoId);
        });
    });




    // Función para añadir promoción
    function addPromotionToCart(promoId) {
        const promotion = promotions[promoId];
        if (!promotion) {
            alert("This promotion is not currently available");
            return;
        }




        const confirmation = confirm(
            `¿Add ${promotion.name} for $${promotion.discountPrice}?\n` +
            `${promotion.description}\n` +
            `(You save $${promotion.originalPrice - promotion.discountPrice})`
        );




        if (confirmation) {
            // En lugar de agregar cada item individualmente, agregamos la promoción como un solo item
            cart.push({
                id: `promo-${promoId}`,
                name: promotion.name,
                price: promotion.discountPrice,
                quantity: 1,
                isPromotion: true,
                description: promotion.description
            });




            updateCart();
            saveCartToLocalStorage();
            showNotification(`✅ ${promotion.name} added to cart`);
           
            // Desplazarse al carrito
            document.querySelector('.container#menu').scrollIntoView({ behavior: 'smooth' });
        }
    }




    // Actualizar carrito
    function updateCart() {
        cartItemsEl.innerHTML = '';
       
        if (cart.length === 0) {
            emptyCartMsg.style.display = 'block';
            cartTotalEl.textContent = '0';
            return;
        }
       
        emptyCartMsg.style.display = 'none';
        let total = 0;
       
        cart.forEach((item, index) => {
            const itemTotal = item.price * item.quantity;
            total += itemTotal;
           
            const cartItemEl = document.createElement('div');
            cartItemEl.className = 'cart-item';
           
            let itemContent = `
                <div class="cart-item-info">
                    <span class="cart-item-name">${item.name} × ${item.quantity}</span>
                    <span class="cart-item-price">$${(item.price * item.quantity).toFixed(0)}</span>
                </div>
            `;
           
            // Si es una promoción, agregar descripción
            if (item.isPromotion && item.description) {
                itemContent += `<div class="cart-item-desc">${item.description}</div>`;
            }
           
            itemContent += `
                <div class="cart-item-actions">
                    <div class="cart-item-quantity">
                        <button class="quantity-btn minus" data-index="${index}">-</button>
                        <span class="item-quantity">${item.quantity}</span>
                        <button class="quantity-btn plus" data-index="${index}">+</button>
                    </div>
                    <button class="remove-item" data-index="${index}">&times;</button>
                </div>
            `;
           
            cartItemEl.innerHTML = itemContent;
            cartItemsEl.appendChild(cartItemEl);
        });
       
        cartTotalEl.textContent = total.toFixed(0);
       
        // Añadir eventos a los nuevos botones
        addCartButtonEvents();
    }
   
    // Añadir eventos a los botones del carrito
    function addCartButtonEvents() {
        // Botones de reducir cantidad
        document.querySelectorAll('.minus').forEach(button => {
            button.addEventListener('click', function() {
                const index = parseInt(this.getAttribute('data-index'));
                if (isNaN(index) || index < 0 || index >= cart.length) return;
               
                if (cart[index].quantity > 1) {
                    cart[index].quantity -= 1;
                } else {
                    cart.splice(index, 1);
                }
               
                updateCart();
                saveCartToLocalStorage();
            });
        });
       
        // Botones de aumentar cantidad
        document.querySelectorAll('.plus').forEach(button => {
            button.addEventListener('click', function() {
                const index = parseInt(this.getAttribute('data-index'));
                if (isNaN(index) || index < 0 || index >= cart.length) return;
               
                cart[index].quantity += 1;
               
                updateCart();
                saveCartToLocalStorage();
            });
        });
       
        // Botones de eliminar item
        document.querySelectorAll('.remove-item').forEach(button => {
            button.addEventListener('click', function() {
                const index = parseInt(this.getAttribute('data-index'));
                if (isNaN(index) || index < 0 || index >= cart.length) return;
               
                const itemName = cart[index].name;
                cart.splice(index, 1);
               
                updateCart();
                saveCartToLocalStorage();
                showNotification(`🗑️ ${itemName} removed from cart`);
            });
        });
    }
   
    // Vaciar carrito
    clearCartBtn.addEventListener('click', function() {
        if (cart.length === 0) return;
       
        if (confirm('Are you sure you want to empty your cart?')) {
            cart = [];
            updateCart();
            localStorage.removeItem('tlb-cart');
            showNotification('🛒 Cart emptied');
        }
    });
   
    // Realizar pedido
    checkoutBtn.addEventListener('click', function() {
        if (cart.length === 0) {
            showNotification('⚠️ Your cart is empty');
            return;
        }
       
        const total = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);
       
        // Crear mensaje de confirmación con items del pedido
        let mensajePedido = "👍 Order placed successfully!\n\nOrder Summary:\n";
        cart.forEach(item => {
            mensajePedido += `- ${item.name} × ${item.quantity}: $${(item.price * item.quantity).toFixed(0)}\n`;
        });
        mensajePedido += `\nTotal: $${total.toFixed(0)}\n\nThank you for your purchase at The Last Burger!`;
       
        alert(mensajePedido);
       
        cart = [];
        updateCart();
        localStorage.removeItem('tlb-cart');
    });
   
    // Guardar carrito
    function saveCartToLocalStorage() {
        localStorage.setItem('tlb-cart', JSON.stringify(cart));
    }
   
    // Mostrar notificación
    function showNotification(message) {
        // Eliminar notificaciones existentes
        const existingNotifications = document.querySelectorAll('.notification');
        existingNotifications.forEach(notification => notification.remove());
       
        const notification = document.createElement('div');
        notification.className = 'notification';
        notification.textContent = message;
        document.body.appendChild(notification);
       
        // Usar setTimeout para aplicar la clase show después del reflow
        setTimeout(() => notification.classList.add('show'), 10);
       
        // Eliminar después de 3 segundos
        setTimeout(() => {
            notification.classList.remove('show');
            setTimeout(() => notification.remove(), 300);
        }, 3000);
    }




    // FAQ - Acordeón
    const faqItems = document.querySelectorAll('.faq-item');
    faqItems.forEach(item => {
        const question = item.querySelector('.faq-question');
        if (question) {
            question.addEventListener('click', () => {
                // Toggle active class
                const currentlyActive = item.classList.contains('active');
               
                // Cerrar todos los items
                faqItems.forEach(faqItem => {
                    faqItem.classList.remove('active');
                });
               
                // Abrir el actual si no estaba activo
                if (!currentlyActive) {
                    item.classList.add('active');
                }
            });
        }
    });
   
    // Smooth scrolling para los enlaces de navegación
    document.querySelectorAll('.main-nav a').forEach(link => {
        link.addEventListener('click', function(e) {
            const href = this.getAttribute('href');
            if (href.startsWith('#')) {
                e.preventDefault();
                const targetElement = document.querySelector(href);
                if (targetElement) {
                    targetElement.scrollIntoView({
                        behavior: 'smooth',
                        block: 'start'
                    });
                }
            }
        });
    });
     
  });
      // Funcionalidad del modal
      const modal = document.getElementById('loginModal');
      const openBtn = document.getElementById('openLoginBtn');
      const closeBtn = document.getElementById('closeModalBtn');
     
      openBtn.addEventListener('click', () => {
          modal.style.display = 'flex';
          document.body.style.overflow = 'hidden'; // Bloquear scroll
      });
     
      closeBtn.addEventListener('click', () => {
          modal.style.display = 'none';
          document.body.style.overflow = 'auto'; // Restaurar scroll
      });
     
      // Cerrar al hacer clic fuera del modal
      window.addEventListener('click', (e) => {
          if (e.target === modal) {
              modal.style.display = 'none';
              document.body.style.overflow = 'auto';
          }
      });


      document.addEventListener('DOMContentLoaded', function() {
        // Modal para trabajadores
        const workerModal = document.getElementById('worker-modal');
        const openWorkerModalBtn = document.getElementById('open-worker-modal-btn');
        const closeWorkerBtn = document.getElementById('close-worker-btn');
    
        // Mostrar el modal de trabajadores cuando se haga clic en el botón
        openWorkerModalBtn.onclick = function() {
            workerModal.style.display = "block";
            document.body.style.overflow = "hidden"; // Bloquear scroll
        };
    
        // Cerrar el modal de trabajadores cuando se haga clic en la "X"
        closeWorkerBtn.onclick = function() {
            workerModal.style.display = "none";
            document.body.style.overflow = "auto"; // Restaurar scroll
        };
    
        // Cerrar el modal si el usuario hace clic fuera del contenido del modal
        window.onclick = function(event) {
            if (event.target === workerModal) {
                workerModal.style.display = "none";
                document.body.style.overflow = "auto"; // Restaurar scroll
            }
        };
    
        // Manejo del formulario de trabajadores (ejemplo básico)
        document.getElementById('worker-form').onsubmit = function(event) {
            event.preventDefault(); // Prevenir el envío normal del formulario
            alert('Form sent to workers');
            workerModal.style.display = "none"; // Cerrar el modal después de enviar
        };
    });

    // =================== Cargar Hamburguesas ===================
const burgersContainer = document.getElementById("burgers-container");

fetch("http://localhost:3000/api/hamburguesas") // Ajusta esta URL si es distinta
  .then(response => response.json())
  .then(data => {
    data.forEach(burger => {
      const card = document.createElement("div");
      card.classList.add("burger-card");

      card.innerHTML = `
        <img src="${burger.imagen}" alt="${burger.nombre}" class="burger-img">
        <div class="burger-info">
          <h3 class="burger-title">${burger.nombre}</h3>
          <p class="burger-desc">${burger.descripcion}</p>
          <span class="burger-price">$${burger.precio}</span>
          <button class="add-to-cart" data-id="${burger.id}" data-name="${burger.nombre}" data-price="${burger.precio}">
            Add to cart
          </button>
        </div>
      `;

      burgersContainer.appendChild(card);
    });
  })
  .catch(error => {
    console.error("Error al cargar hamburguesas:", error);
    burgersContainer.innerHTML = "<p></p>";
  });


// =================== Cargar Entrantes ===================
const entrantesContainer = document.getElementById("entrantes-container");

fetch("http://localhost:3000/api/entrantes")
  .then(response => response.json())
  .then(data => {
    data.forEach(entrante => {
      const card = document.createElement("div");
      card.classList.add("entrante");

      card.innerHTML = `
        <img src="${entrante.imagen}" alt="${entrante.nombre}">
        <h3>${entrante.nombre}</h3>
        <p>${entrante.descripcion}</p>
        <span class="precio">$${entrante.precio}</span>
        <button class="add-to-cart" data-id="${entrante.id}" data-name="${entrante.nombre}" data-price="${entrante.precio}">
          Add to cart
        </button>
      `;

      entrantesContainer.appendChild(card);
    });
  })
  .catch(error => {
    console.error("Error al cargar entrantes:", error);
    entrantesContainer.innerHTML = "<p>Failed to load starters.</p>";
  });


// =================== Cargar Bebidas ===================
const bebidasContainer = document.getElementById("beverages-container");

fetch("http://localhost:3000/api/bebidas")
  .then(response => response.json())
  .then(data => {
    data.forEach(bebida => {
      const card = document.createElement("div");
      card.classList.add("beverage-card");

      card.innerHTML = `
        <img src="${bebida.imagen}" alt="${bebida.nombre}" class="beverage-img">
        <div class="beverage-info">
          <h3 class="beverage-title">${bebida.nombre}</h3>
          <p class="beverage-desc">${bebida.descripcion}</p>
          <span class="beverage-price">$${bebida.precio}</span>
          <button class="add-to-cart" data-id="${bebida.id}" data-name="${bebida.nombre}" data-price="${bebida.precio}">
            Add to cart
          </button>
        </div>
      `;

      bebidasContainer.appendChild(card);
    });
  })
  .catch(error => {
    console.error("Error al cargar bebidas:", error);
    bebidasContainer.innerHTML = "<p>Failed to load beverages.</p>";
  });

    




    

     
   







