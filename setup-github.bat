@echo off
echo ========================================
echo OpenCart Testing Project - GitHub Setup
echo ========================================
echo.

echo Setting up Git and pushing to GitHub...
echo.

REM Add Git to PATH
set PATH=%PATH%;"C:\Program Files\Git\bin"
set PATH=%PATH%;"C:\Program Files (x86)\Git\bin"

REM Check if Git is available
git --version
if %errorlevel% neq 0 (
    echo ERROR: Git is not available. Please install Git first.
    echo Visit: https://git-scm.com/download/win
    pause
    exit /b 1
)

echo Git is available!
echo.

REM Navigate to project directory
cd /d "c:\Users\SHRAVAN\Documents\GitHub\Open-Cart---Ecommerce-Testing"

REM Configure Git (if not already configured)
echo Configuring Git...
git config --global user.name "Prasanna Adepu"
git config --global user.email "prasanna.adepu@example.com"
echo.

REM Initialize repository if not already done
if not exist .git (
    echo Initializing Git repository...
    git init
    echo.
)

REM Add all files
echo Adding files to Git...
git add .
echo.

REM Check status
echo Git status:
git status
echo.

REM Create commit
echo Creating commit...
git commit -m "Initial commit: OpenCart E-commerce Testing Project

- Complete Selenium WebDriver automation framework
- Page Object Model implementation with Java
- TestNG test suites for comprehensive testing
- Comprehensive documentation and manual test cases
- Author: Prasanna Adepu (QA Automation Fresher)

This is my first end-to-end testing project built from scratch,
demonstrating skills in Java, Selenium, TestNG, and Maven.
Overcame challenges in framework design, tool integration,
and debugging complex automation scenarios using modern AI tools."
echo.

echo ========================================
echo IMPORTANT: Next Steps for GitHub
echo ========================================
echo.
echo 1. Create a new repository on GitHub:
echo    - Go to https://github.com
echo    - Click 'New repository'
echo    - Name: Open-Cart---Ecommerce-Testing
echo    - Description: Comprehensive e-commerce testing with Selenium - Built by Prasanna Adepu
echo    - Make it PUBLIC
echo    - DO NOT initialize with README or .gitignore
echo.
echo 2. Copy the repository URL from GitHub
echo.
echo 3. Run these commands (replace YOUR_USERNAME):
echo    git remote add origin https://github.com/YOUR_USERNAME/Open-Cart---Ecommerce-Testing.git
echo    git push -u origin main
echo.
echo 4. If you get authentication errors, use a Personal Access Token:
echo    - Go to https://github.com/settings/tokens
echo    - Generate new token with repo permissions
echo    - Use token as password when pushing
echo.

pause