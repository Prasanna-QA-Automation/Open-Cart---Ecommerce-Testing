# OpenCart E-commerce Testing Project

This project demonstrates comprehensive testing skills for an e-commerce application using OpenCart as the test subject. It includes both automated testing with Selenium WebDriver and Java, as well as manual testing documentation.

## 👨‍💻 About the Author

**Prasanna Adepu** - QA Automation Engineer

This is my **first comprehensive testing project** built from scratch after completing theoretical and practical training in software testing. As a fresher stepping into the QA field, I faced numerous challenges but successfully delivered a production-ready test automation framework.

### 🎯 Project Journey & Challenges Faced

**Background**: This project was developed under the guidance of my trainer as part of my transition from theoretical learning to practical implementation.

**Key Challenges Overcome**:
- **Learning Curve**: As a beginner, understanding Selenium WebDriver 4.x, Maven, and TestNG required extensive self-study
- **Framework Design**: Implementing Page Object Model and designing a scalable architecture from scratch
- **Tool Integration**: Configuring ExtentReports, Log4j2, and WebDriverManager for seamless operation
- **Cross-browser Testing**: Setting up automated browser management and handling compatibility issues
- **Debugging & Troubleshooting**: Resolving dependency conflicts, WebDriver issues, and synchronization problems
- **Documentation**: Creating comprehensive test cases, setup guides, and professional documentation
- **Best Practices**: Researching and implementing industry-standard testing methodologies

**Skills Upskilled**:
- **AI Tools Integration**: Leveraged GitHub Copilot and other AI assistants for code generation and problem-solving
- **Modern Technologies**: Adopted current market requirements (Selenium 4, Java 11, TestNG 7.x)
- **Continuous Learning**: Self-taught advanced concepts like parallel execution, reporting frameworks
- **Problem-solving**: Developed analytical thinking for complex automation scenarios

**Personal Growth**: This project represents my transformation from a trainee to a confident QA professional, demonstrating the ability to learn, adapt, and deliver quality solutions independently.

---

## Project Structure

```
Open-Cart---Ecommerce-Testing/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/opencart/
│   │   │       ├── pages/          # Page Object Model classes
│   │   │       └── utils/          # Utility classes
│   │   └── resources/
│   │       └── log4j2.xml         # Logging configuration
│   └── test/
│       ├── java/
│       │   └── com/opencart/tests/ # Test classes
│       └── resources/
│           └── testdata/           # Test data files
├── docs/                          # Documentation
├── reports/                       # Test reports
├── pom.xml                        # Maven configuration
├── testng.xml                     # TestNG suite configuration
├── run-tests.bat                  # Windows batch script
├── AUTHOR.md                      # Author profile and journey
├── PROJECT_SUMMARY.md             # Project summary
└── README.md
```

## Features Tested

### Automated Testing (Selenium WebDriver)
- **User Registration**: Valid and invalid registration scenarios
- **User Login**: Authentication with valid/invalid credentials
- **Product Search**: Search functionality with various inputs
- **Shopping Cart**: Add to cart, view cart, quantity updates
- **Page Object Model**: Maintainable and reusable page classes

### Manual Testing
- Complete test cases for all major functionalities
- Cross-browser compatibility testing
- Mobile responsiveness testing
- Performance testing scenarios
- Security testing (XSS, SQL injection)

## Technologies Used

- **Java 11**: Programming language
- **Selenium WebDriver 4.15.0**: Browser automation
- **TestNG 7.8.0**: Testing framework
- **WebDriverManager 5.5.3**: Automatic driver management
- **Maven**: Build and dependency management
- **Log4j2**: Logging framework
- **ExtentReports**: Test reporting

## Prerequisites

- Java 11 or higher
- Maven 3.6+
- Chrome or Firefox browser
- Internet connection (for OpenCart demo site)

## Setup Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/Open-Cart---Ecommerce-Testing.git
   cd Open-Cart---Ecommerce-Testing
   ```

2. **Ensure Java 11+ is installed:**
   ```bash
   java -version
   ```

3. **Install dependencies and run tests:**
   ```bash
   # Using the provided batch file (Windows)
   run-tests.bat

   # Or using Maven directly (if installed)
   mvn clean test

   # Or using Maven wrapper
   .\mvnw.cmd clean test
   ```

## Quick Start

**For Windows users:**
- Double-click `run-tests.bat` to execute all tests
- Check `reports/` folder for results

**For manual execution:**
```bash
# Compile the project
mvn clean compile

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTest

# Run with different browser
mvn test -Dbrowser=firefox
```

## Test Execution

### Command Line Execution
```bash
# Run all tests
mvn clean test

# Run specific test class
mvn test -Dtest=LoginTest

# Run with TestNG suite
mvn test -DsuiteXmlFile=testng.xml
```

### IDE Execution
- Import project as Maven project in your IDE
- Run test classes directly from IDE
- Use TestNG plugin for better test management

## Browser Configuration

The project supports multiple browsers:
- **Chrome** (default): `mvn test -Dbrowser=chrome`
- **Firefox**: `mvn test -Dbrowser=firefox`

## Test Reports

Test reports are generated in the `reports/` directory:
- ExtentReports HTML reports
- TestNG HTML reports
- Screenshots for failed tests

## Page Object Model

The project uses Page Object Model design pattern:
- Each page has its own class
- Methods represent user actions
- Elements are defined using @FindBy annotations
- WebDriverWait for synchronization

## Test Data Management

Test data is managed through JSON files in `src/test/resources/testdata/`:
- User credentials
- Product information
- Registration data

## Logging

Log4j2 is configured for comprehensive logging:
- Console and file logging
- Different log levels (DEBUG, INFO, WARN, ERROR)
- Logs saved in `logs/` directory

## Manual Testing

Refer to `docs/ManualTestCases.md` for comprehensive manual test cases covering:
- Functional testing
- UI/UX testing
- Cross-browser testing
- Performance testing
- Security testing

## Best Practices Implemented

1. **Page Object Model**: For maintainable code
2. **Data-Driven Testing**: External test data
3. **Cross-Browser Testing**: Multiple browser support
4. **Logging**: Comprehensive logging framework
5. **Reporting**: Detailed test reports
6. **Version Control**: Proper .gitignore configuration
7. **Build Management**: Maven for dependency management

## Continuous Integration

The project is CI/CD ready:
- Maven build configuration
- TestNG XML suites
- Headless browser support
- Automated driver management

## Troubleshooting

### Common Issues

1. **WebDriver issues**: WebDriverManager handles driver downloads automatically
2. **Test failures**: Check browser version compatibility
3. **Network issues**: Ensure stable internet connection for demo site
4. **Port conflicts**: Close other browser instances if needed

### Debug Mode

Run tests in non-headless mode for debugging:
- Remove headless arguments from WebDriverManagerUtil
- Add Thread.sleep() for debugging (not recommended for production)

## Contributing

1. Fork the repository
2. Create a feature branch
3. Add tests for new functionality
4. Ensure all tests pass
5. Submit a pull request

## Future Enhancements

- API testing integration
- Database testing
- Performance testing with JMeter
- CI/CD pipeline with Jenkins/GitHub Actions
- Docker containerization
- Mobile testing with Appium

## License

This project is for educational purposes. OpenCart demo site terms apply.


**Prasanna Adepu**
- **Role**: QA Automation Engineer (Fresher)
- **Location**: India
- **Experience**: This is my first comprehensive testing project after training
- **Skills**: Java, Selenium WebDriver, TestNG, Maven, Manual Testing
- **Learning Focus**: AI-assisted development, modern testing frameworks, automation best practices

**Project Background**: Built this end-to-end testing framework from scratch as part of my transition from theoretical training to practical implementation. Overcame numerous challenges including framework design, tool integration, and debugging complex automation scenarios.

**Professional Goal**: To become a proficient QA Automation Engineer by continuously learning and implementing industry-standard testing practices.

For questions, suggestions, or collaboration opportunities, feel free to reach out!

📄 **Detailed Author Profile**: See [AUTHOR.md](AUTHOR.md) for comprehensive information about my background, challenges, and journey.

---

**Note**: This project represents my journey as a fresher in QA automation, showcasing the ability to learn, adapt, and deliver quality solutions using modern tools and methodologies.