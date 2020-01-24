############################################
#
# @author ngoanh2n@gmail.com (Ho Huu Ngoan)
#
############################################

@HomeWelcome
Feature: Gitlab
  test displaying home welcome title for client

  Scenario: HomePage
  to confirm that the title correctly when this account does not have any repositories
    Given I open Gitlab page
    And I login with account "anonymous.automation" / "ngoanh2n"
    Then I see welcome title is "Welcome to GitLab"