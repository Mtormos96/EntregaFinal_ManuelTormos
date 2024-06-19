// cypress/e2e/view_edit_cart.cy.js
describe('Ver y Editar Carrito', () => {
    const BASE_URL = 'http://opencart.abstracta.us/index.php?route=common/home';

    beforeEach(() => {
        cy.visit(BASE_URL);
        cy.get('.product-thumb').first().find('button[onclick^="cart.add"]').click();
    });

    it('Debería mostrar los productos en el carrito', () => {
        cy.get('#cart > button').click();
        cy.get('.dropdown-menu').contains('View Cart').click();
        cy.url().should('include', 'route=checkout/cart');
        cy.get('.table-responsive .text-left').should('have.length.at.least', 1);
    });

    it('Debería eliminar un producto del carrito', () => {
        // Abre el carrito
        cy.get('#cart > button').click();
        // Hace clic en "View Cart"
        cy.get('.dropdown-menu').contains('View Cart').click();
        // Asegúrate de que hay al menos un producto en la tabla
        cy.get('.table-responsive .text-left').should('have.length.at.least', 1);
        // Hace clic en el botón de eliminar del primer producto en la tabla
        cy.get('.table-responsive .btn-danger').first().click();
        // Verifica que el carrito ya no contiene '1 item(s)'
        cy.get('#cart-total').should('not.contain', '1 item(s)');
    });
    
    it('Debería actualizar la cantidad de un producto en el carrito', () => {
        cy.get('#cart > button').click();
        cy.get('.dropdown-menu').contains('View Cart').click();
        cy.get('.table-responsive .text-left').should('have.length.at.least', 1);
        cy.get('.form-control').first().clear().type('2');
        cy.get('.btn-primary').contains('Update').click();
        cy.get('#cart-total').should('contain', '2 item(s)');
    });
});
