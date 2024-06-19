// cypress/e2e/add_to_cart.cy.js
describe('Agregar Producto al Carrito', () => {
    const BASE_URL = 'http://opencart.abstracta.us/index.php?route=common/home';

    beforeEach(() => {
        cy.visit(BASE_URL);
    });

    it('Debería agregar un producto al carrito y mostrar el mensaje de confirmación', () => {
        // Localiza el primer producto y haz clic en "Add to Cart"
        cy.get('.product-layout').first().find('button[onclick^="cart.add"]').click();
        
        // Verifica que se muestre el mensaje de éxito
        cy.get('.alert-success').should('contain', 'Success: You have added');
        
        // Verifica que el total del carrito se haya actualizado
        cy.get('#cart-total').should('contain', '1 item(s)');
    });
});