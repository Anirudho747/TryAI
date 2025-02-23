const { remote } = require('webdriverio');

describe('Create Lead', () => {
  it('should create a new lead', async () => {
    // Initialize the browser
    const browser = await remote({
      capabilities: {
        browserName: 'chrome',
      },
    });

    try {
      // Navigate to the URL
      await browser.url('http://leaftaps.com/opentaps');

      // Maximize the browser window
      await browser.maximizeWindow();

      // Login
      const loginPage = await browser.$('***');

      // Username and password fields
      await (await browser.$('#username')).setValue('DemoSalesManager');
      await (await browser.$('#password')).setValue('crmsfa');
      await (await browser.$('.decorativeSubmit')).click();

      // Verify title after login
      const title = await browser.getTitle();
      console.log('Title after login:', title);

      // Navigate to CRM/SFA and Create Lead
      await (await browser.$('***')).click();
      await (await browser.$('***')).click();

      // Fill create lead form
      const createLeadForm = await browser.$('***');

      await (await createLeadForm.$('#createLeadForm_companyName')).setValue('TestLeaf');
      await (await createLeadForm.$('#createLeadForm_firstName')).setValue('Babu');
      await (await createLeadForm.$('#createLeadForm_lastName')).setValue('Manikeerthy');

      // Handle dropdowns
      const dataSource = await createLeadForm.$('#createLeadForm_dataSourceId');
      await dataSource.selectOption('Employee');

      const marketingCampaign = await createLeadForm.$('#createLeadForm_marketingCampaignId');
      await marketingCampaign.selectOption('9001');

      // Submit form
      await (await createLeadForm.$('***')).click();

      // Verify new title
      const newTitle = await browser.getTitle();
      console.log('Title after creating lead:', newTitle);
    } finally {
      // Cleanup
      await browser.deleteSession();
    }
  });
});