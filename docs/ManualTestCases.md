# OpenCart E-commerce Manual Test Cases

## 1. User Registration

### TC001: Successful User Registration
**Test Steps:**
1. Navigate to OpenCart demo site
2. Click on "My Account" > "Register"
3. Fill all required fields with valid data
4. Check "I have read and agree to the Privacy Policy"
5. Click "Continue"

**Expected Result:** User should be registered successfully and redirected to My Account page

### TC002: Registration with Existing Email
**Test Steps:**
1. Navigate to registration page
2. Enter details with an email that already exists
3. Fill other required fields
4. Click "Continue"

**Expected Result:** Error message should be displayed indicating email already exists

### TC003: Registration with Invalid Data
**Test Steps:**
1. Navigate to registration page
2. Leave required fields empty or enter invalid data
3. Click "Continue"

**Expected Result:** Validation errors should be displayed for each invalid field

## 2. User Login

### TC004: Successful Login
**Test Steps:**
1. Navigate to login page
2. Enter valid email and password
3. Click "Login"

**Expected Result:** User should be logged in and redirected to My Account page

### TC005: Invalid Login Credentials
**Test Steps:**
1. Navigate to login page
2. Enter invalid email/password
3. Click "Login"

**Expected Result:** Error message should be displayed

### TC006: Forgotten Password
**Test Steps:**
1. Navigate to login page
2. Click "Forgotten Password"
3. Enter registered email
4. Click "Continue"

**Expected Result:** Success message should be displayed

## 3. Product Search

### TC007: Search Existing Product
**Test Steps:**
1. Navigate to home page
2. Enter existing product name in search box
3. Click search button

**Expected Result:** Search results should be displayed

### TC008: Search Non-existing Product
**Test Steps:**
1. Enter non-existing product name
2. Click search

**Expected Result:** "No results" message should be displayed

### TC009: Empty Search
**Test Steps:**
1. Leave search box empty
2. Click search

**Expected Result:** All products or appropriate message should be displayed

## 4. Shopping Cart

### TC010: Add Product to Cart
**Test Steps:**
1. Navigate to product page
2. Click "Add to Cart"

**Expected Result:** Success message should be displayed

### TC011: View Shopping Cart
**Test Steps:**
1. Click on shopping cart icon

**Expected Result:** Shopping cart page should be displayed with added items

### TC012: Update Cart Quantity
**Test Steps:**
1. Add product to cart
2. Go to cart page
3. Update quantity
4. Click update

**Expected Result:** Cart should be updated with new quantity

## 5. Checkout Process

### TC013: Guest Checkout
**Test Steps:**
1. Add product to cart
2. Click "Checkout"
3. Select guest checkout
4. Fill billing details
5. Continue through all steps
6. Confirm order

**Expected Result:** Order should be placed successfully

### TC014: Registered User Checkout
**Test Steps:**
1. Login as registered user
2. Add product to cart
3. Proceed to checkout
4. Use saved address
5. Complete checkout

**Expected Result:** Order should be placed successfully

## 6. Product Categories

### TC015: Browse Categories
**Test Steps:**
1. Click on any category (e.g., Desktops)
2. Click "Show All"

**Expected Result:** Category page should display all products in that category

### TC016: Product Sorting
**Test Steps:**
1. Go to category page
2. Select different sort options

**Expected Result:** Products should be sorted accordingly

## 7. Cross-browser Testing

### TC017: Chrome Browser Compatibility
**Test Steps:**
1. Open site in Chrome
2. Perform basic operations (login, search, add to cart)

**Expected Result:** All functionality should work

### TC018: Firefox Browser Compatibility
**Test Steps:**
1. Open site in Firefox
2. Perform same operations

**Expected Result:** All functionality should work

## 8. Mobile Responsiveness

### TC019: Mobile View
**Test Steps:**
1. Resize browser to mobile dimensions
2. Navigate through site

**Expected Result:** Site should be responsive and usable on mobile

## 9. Performance Testing

### TC020: Page Load Time
**Test Steps:**
1. Navigate to home page
2. Measure load time

**Expected Result:** Page should load within acceptable time (< 3 seconds)

### TC021: Search Performance
**Test Steps:**
1. Perform search operations
2. Measure response time

**Expected Result:** Search should be fast

## 10. Security Testing

### TC022: SQL Injection Test
**Test Steps:**
1. In search field, enter SQL injection strings
2. Submit

**Expected Result:** No SQL errors, proper sanitization

### TC023: XSS Test
**Test Steps:**
1. Enter script tags in form fields
2. Submit

**Expected Result:** Scripts should not execute

## Test Execution Checklist

- [ ] All manual test cases executed
- [ ] Screenshots captured for failures
- [ ] Test results documented
- [ ] Defects logged in bug tracking system
- [ ] Test summary report prepared