# java-exchange-converter

This is a Java application for currency conversion using the ExchangeRate API. It allows users to convert between different currencies, displaying up-to-date exchange rates retrieved from the API.

## Features

- Convert between specified currencies (e.g., USD to CLP, CLP to USD)
- Uses the ExchangeRate API for live exchange rate data
- Command-line interface for user input

## Setup

### Requirements

- Java 11 or higher
- ExchangeRate API key (sign up at [ExchangeRate API](https://www.exchangerate-api.com) to obtain your key)

### Getting Started

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name

2. **Set up the API Key**

You have two options to configure the API key securely without hard-coding it into your code.

**Option 1: Use Environment Variables**
Set an environment variable named API_KEY with your ExchangeRate API key.

- **On Windows**: Run this in Command Prompt:

   ```bash
   setx API_KEY "your_api_key_here"
- **On macOS/Linux**: Run this in the terminal:
   ```bash
   export API_KEY="your_api_key_here"

The application will automatically retrieve this environment variable at runtime.

**Option 2: Use a .properties File**
- Create a file named config.properties in the project root directory.

- Add the following content to config.properties, replacing "your_api_key_here" with your actual API key:
   ```properties
   api_key=your_api_key_here
- In config.properties, this file should be excluded from version control to keep your API key secure. Add it to your .gitignore file:
   ```bash
   echo "config.properties" >> .gitignore

### Usage
- To start the application, run the Principal class from the command line or an IDE.
   ```bash
   java -cp your-compiled-jar-file.jar Principal


Once running, follow the on-screen menu to select your desired currency conversion.
### Example Output
   ```markdown
   ***********************************************
   **** Bienvenido/a al conversor de monedas *****
   ******************* MENU **********************
   ***** Seleccione una divisa a convertir *******
   * 1.- Dólar(USD) a Peso Chileno(CLP)          *
   * 2.- Peso Chileno a Dólar                    *
   * 3.- Euro(EUR) a Peso Chileno(CLP)           *
   * 4.- Peso Chileno a Euro(EUR)                *
   * 5.- Real Brasileño(BRL) a Peso Chileno(CLP) *
   * 6.- Peso Chileno a Real Brasileño(BRL)      *
   * 9.- Salir                                   *
   **      Seleccione una opción valida:        **
   ***********************************************
   ```

### Code Overview
### `CurrencyExchange` Class
This class is responsible for making API requests to the ExchangeRate API and calculating conversion rates.

### `Currency` Record
`Currency` is a Java record that represents the API response. It contains fields such as `conversionRate`, `conversionResult`, and others to hold the conversion data.

- **Methods**:
  - `currencyExchange(String baseCurrency, String targetCurrency, double amount)`: 
     Converts the amount from the base currency to the target currency using real-time exchange rates from the API.



### Troubleshooting
- **Error**: `Could not load API key`:
   - Verify that your `API_KEY` environment variable is set, or the `config.properties` file is correctly set up.
- **Error connecting to the API**:
   - Check your internet connection and ensure the API key is valid.

### License
This project is licensed under the MIT License.
