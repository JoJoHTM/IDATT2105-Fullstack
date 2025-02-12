describe('Visit feedbackform', () => {
  it('Opens up the feedbackform and renders', () => {
    cy.visit('http://localhost:5173/feedback')
    cy.get('form').should('exist')
  })
})

describe('Feedbackform', () => {
  it('Submit form should be disabled', () => {
    cy.visit('http://localhost:5173/feedback')
    cy.get('#submit').should('be.disabled')
  })
})

describe('Feedbackform', () => {
  it('Submit form should be enabled', () => {
    cy.visit('http://localhost:5173/feedback')
    cy.get('#name').type('Jonas Johansen')
    cy.get('#email').type('jonasgjo@stud.ntnu.no')
    cy.get('#feedback').type('This is a test')
    cy.get('#submit').click()
    cy.get('h2').should('contain', 'Takk for din tilbakemelding')
  })
})