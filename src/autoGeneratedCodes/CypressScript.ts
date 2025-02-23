describe('Create Lead', () => {
  it('creates a new lead', () => {
    // Launch browser and navigate to URL
    cy.visit('http://leaftaps.com/opentaps');

    // Login
    cy.get('#username').type('DemoSalesManager');
    cy.get('#password').type('crmsfa');
    cy.get('.decorativeSubmit').click();

    // Navigate to Create Lead
    cy.contains('CRM/SFA').click();
    cy.contains('Create Lead').click();

    // Fill Create Lead form
    cy.get('#createLeadForm_companyName').type('TestLeaf');
    cy.get('#createLeadForm_firstName').type('Babu');
    cy.get('#createLeadForm_lastName').type('Manickam');

    // Handle dropdowns
    cy.get('#createLeadForm_dataSourceId').click();
    cy.contains('Employee').click();
    
    cy.get('#createLeadForm_marketingCampaignId').click();
    cy.contains('9001').click();

    // Submit form
    cy.get('[name="submitButton"]').click();

    // Verify title after submission
    cy.title().should('contain', 'View Lead');
  });
});