// cypress/e2e/purchase_product.cy.js
describe('Comprar Producto', () => {
    const BASE_URL = 'http://opencart.abstracta.us/index.php?route=common/home';

    beforeEach(() => {
        cy.visit(BASE_URL);
    });

    it('Debería comprar un iPhone y un monitor Apple Cinema 30"', () => {
        // Agrega el iPhone al carrito
        cy.get('.product-thumb').contains('iPhone').parents('.product-thumb').find('button[onclick^="cart.add"]').click();
        
        // Agrega el monitor Apple Cinema 30" al carrito
        cy.get('.product-thumb').contains('Apple Cinema 30"').parents('.product-thumb').find('button[onclick^="cart.add"]').click();
        
        // Abrir el carrito
        cy.get('#cart > button').click();
        
        // Ir a Checkout
        cy.get('.dropdown-menu').contains('Checkout').click();

        // Llenar los detalles de checkout
        // Asumiendo que se necesita un inicio de sesión
        cy.get('#input-email').type('testuser@example.com');
        cy.get('#input-password').type('password');
        cy.get('#button-login').click();

        // Completar las direcciones y métodos de pago/envío
        cy.get('#button-payment-address').click();
        cy.get('#button-shipping-address').click();
        cy.get('#button-shipping-method').click();
        cy.get('#input-payment-method').check();
        cy.get('#button-payment-method').click();
        cy.get('#button-confirm').click();

        // Verificar el mensaje de confirmación
        cy.get('.breadcrumb').should('contain', 'Your order has been placed!');
    });
});
