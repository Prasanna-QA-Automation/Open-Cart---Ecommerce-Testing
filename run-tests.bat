@echo off
echo ========================================
echo OpenCart E-commerce Testing Project
echo ========================================
echo.

echo Setting up environment...
echo.

REM Check if Java is available
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo ERROR: Java is not installed or not in PATH.
    echo Please install Java 11 or higher and add it to your PATH.
    pause
    exit /b 1
)

echo Java is available.
echo.

REM Check if Maven is available
mvn -version >nul 2>&1
if %errorlevel% neq 0 (
    echo Maven not found. Using Maven Wrapper...
    echo.

    REM Try Maven wrapper
    if exist mvnw.cmd (
        echo Using Maven Wrapper...
        call .\mvnw.cmd clean test
    ) else (
        echo ERROR: Neither Maven nor Maven Wrapper found.
        echo Please install Maven or ensure mvnw.cmd is present.
        pause
        exit /b 1
    )
) else (
    echo Maven is available.
    call mvn clean test
)

echo.
echo Test execution completed.
echo Check the 'reports' folder for test results.
echo.
pause