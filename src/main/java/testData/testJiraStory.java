package testData;

public class testJiraStory {

    public static String jiraStory =
            "JIRA Story: Title: As a user, I want to be able to move unused items from my cart to the \"Buy Later\" section so that I can purchase them later. \n" +
                    "Description: When a user has added multiple items to their cart but only wants to purchase a subset of them, they should be able to move the remaining items to the \"Buy Later\" section. This will allow them to save the items for future purchases without having to re-add them to their cart.\n" +
                    "Acceptance Criteria:\n" +
                    "1. The user can add multiple items to their cart.\n" +
                    "2. The user can select which items to purchase and which to move to the \"Buy Later\" section.\n" +
                    "3. The items moved to the \"Buy Later\" section are removed from the cart.\n" +
                    "4. The items in the \"Buy Later\" section are retained for future purchases.\n" +
                    "5. The user can view the items in the \"Buy Later\" section and add them back to their cart if desired.\n" +
                    "Tech Notes:\n" +
                    "* Create a new table in the MySQL database to store the \"Buy Later\" items, with the following columns:\n" +
                    "    * id (primary key)\n" +
                    "    * user_id (foreign key referencing the users table)\n" +
                    "    * product_id (foreign key referencing the products table)\n" +
                    "    * added_at (timestamp)\n" +
                    "* Create a new endpoint in the backend API to handle moving items from the cart to the \"Buy Later\" section.\n" +
                    "* Update the React Native app to send a request to the new endpoint when the user selects items to move to the \"Buy Later\" section.\n" +
                    "* Update the React Native app to display the items in the \"Buy Later\" section and allow the user to add them back to their cart.\n" +
                    "* Use TypeScript to define the types for the \"Buy Later\" items and the API endpoint.\n" +
                    "Test Notes:\n" +
                    "1. Test that the user can add multiple items to their cart.\n" +
                    "2. Test that the user can select items to move to the \"Buy Later\" section.\n" +
                    "3. Test that the items are removed from the cart and added to the \"Buy Later\" section.\n" +
                    "4. Test that the items in the \"Buy Later\" section are retained for future purchases.\n" +
                    "5. Test that the user can view the items in the \"Buy Later\" section and add them back to their cart.\n" +
                    "6. Test that the API endpoint is called correctly when the user moves items to the \"Buy Later\" section.\n" +
                    "7. Test that the \"Buy Later\" items are displayed correctly in the React Native app.";
}
