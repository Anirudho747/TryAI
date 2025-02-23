import { chromium } from 'playwright';

async function createLead() {
  const browser = await chromium.launch();
  const page = await browser.newPage();

  // Navigate to the URL
  await page.goto('http://leaftaps.com/opentaps');

  // Login
  await page.locator('#username').fill('DemoSalesManager');
  await page.locator('#password').fill('crmsfa');
  await page.locator('.decorativeSubmit').click();

  // Verify title after login
  console.log(await page.title());

  // Navigate to CRM/SFA and Create Lead
  await page.click('text="CRM/SFA"');
  await page.click('text="Create Lead"');

  // Fill create lead form
  await page.locator('#createLeadForm_companyName').fill('TestLeaf');
  await page.locator('#createLeadForm_firstName').fill('Babu');
  await page.locator('#createLeadForm_lastName').fill('Manickam');

  // Handle dropdowns
  await page.locator('#createLeadForm_dataSourceId').selectOption('Employee');
  await page.locator('#createLeadForm_marketingCampaignId').selectOption('9001');

  // Submit form
  await page.locator('name="submitButton"').click();

  // Verify title after submission
  console.log(await page.title());

  // Cleanup
  await browser.close();
}

createLead();