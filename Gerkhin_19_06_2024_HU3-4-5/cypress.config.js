const { defineConfig } = require('cypress');
const { allureCypress } = require("allure-cypress/reporter");

module.exports = defineConfig({
  reporter: 'cypress-mochawesome-reporter',
  reporterOptions: {
    charts: true,
    reportPageTitle: 'Cypress-university-test',
    embeddedScreenshots: false,
    inlineAssets: true,
    saveAllAttempts: false,
  },
  e2e: {
    chromeWebSecurity: false,
    baseUrl: 'http://opencart.abstracta.us/index.php?route=common/home',
    setupNodeEvents(on, config) {
      // Implementa aquí los event listeners
      require('cypress-mochawesome-reporter/plugin')(on);
      allureCypress(on, {
        resultsDir: "./allure-results"
      });
      return config;
    }
  },
});
