# GitHub Repository Setup Guide

## Step 1: Install Git (if not already installed)

### Option A: Using Windows Package Manager (Recommended)
```bash
winget install --id Git.Git -e --source winget
```

### Option B: Download from Official Website
1. Go to https://git-scm.com/download/win
2. Download and install Git for Windows
3. Restart your command prompt/terminal

### Option C: Using Chocolatey (if installed)
```bash
choco install git
```

## Step 2: Verify Git Installation
```bash
git --version
```
Expected output: `git version 2.x.x`

## Step 3: Configure Git (First Time Setup)
```bash
# Set your name and email (replace with your actual details)
git config --global user.name "Prasanna Adepu"
git config --global user.email "your-email@example.com"

# Verify configuration
git config --global user.name
git config --global user.email
```

## Step 4: Initialize Git Repository
```bash
cd "c:\Users\SHRAVAN\Documents\GitHub\Open-Cart---Ecommerce-Testing"
git init
```

## Step 5: Add All Files to Git
```bash
# Add all project files
git add .

# Check status
git status
```

## Step 6: Create Initial Commit
```bash
git commit -m "Initial commit: OpenCart E-commerce Testing Project

- Complete Selenium WebDriver automation framework
- Page Object Model implementation
- TestNG test suites
- Comprehensive documentation
- Manual test cases
- Author: Prasanna Adepu (QA Automation Fresher)

This is my first end-to-end testing project built from scratch,
demonstrating skills in Java, Selenium, TestNG, and Maven.
Overcame challenges in framework design, tool integration,
and debugging complex automation scenarios."
```

## Step 7: Create GitHub Repository

### Option A: Using GitHub Website
1. Go to https://github.com and sign in
2. Click "New repository"
3. Repository name: `Open-Cart---Ecommerce-Testing`
4. Description: `Comprehensive e-commerce testing project with Selenium WebDriver - Built by Prasanna Adepu`
5. Choose Public or Private
6. **DO NOT** initialize with README, .gitignore, or license
7. Click "Create repository"

### Option B: Using GitHub CLI (if installed)
```bash
gh repo create Open-Cart---Ecommerce-Testing --public --description "Comprehensive e-commerce testing project with Selenium WebDriver - Built by Prasanna Adepu"
```

## Step 8: Connect Local Repository to GitHub
```bash
# Replace 'your-username' with your actual GitHub username
git remote add origin https://github.com/your-username/Open-Cart---Ecommerce-Testing.git

# Verify remote
git remote -v
```

## Step 9: Push to GitHub
```bash
# Push the main branch
git push -u origin main

# If you get an error about 'main' vs 'master', try:
git branch -M main
git push -u origin main
```

## Step 10: Verify on GitHub
1. Go to your GitHub repository URL
2. Confirm all files are uploaded
3. Check that the README.md displays correctly
4. Verify the repository description and topics

## Troubleshooting

### If Git Push Fails:
```bash
# Check if remote is set correctly
git remote -v

# If wrong remote, remove and add correct one
git remote remove origin
git remote add origin https://github.com/your-username/Open-Cart---Ecommerce-Testing.git

# Try push again
git push -u origin main
```

### If Authentication Issues:
```bash
# Use Personal Access Token instead of password
# Generate token at: https://github.com/settings/tokens
git push -u origin main
```

### If Branch Name Issues:
```bash
# Check current branch
git branch

# Rename to main if needed
git branch -M main
git push -u origin main
```

## Repository Structure (What Should Be on GitHub)
```
Open-Cart---Ecommerce-Testing/
├── .mvn/wrapper/
├── docs/
├── src/
├── .gitignore
├── AUTHOR.md
├── pom.xml
├── PROJECT_SUMMARY.md
├── README.md
├── run-tests.bat
├── testng.xml
└── mvnw.cmd
```

## Final Steps
1. Add repository topics on GitHub: `selenium`, `java`, `testing`, `automation`, `qa`, `opencart`
2. Add a repository description
3. Consider adding a GitHub Pages site for documentation
4. Share your repository link for job applications!

## 🎉 Success Indicators
- All files visible on GitHub
- README.md renders properly
- Repository has proper description
- Commit message is descriptive
- Author information is highlighted

**Your professional QA automation portfolio is now live on GitHub! 🚀**