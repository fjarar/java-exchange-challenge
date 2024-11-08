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

2. **Set up the API Key

You have two options to configure the API key securely without hard-coding it into your code.

Option 1: Use Environment Variables
Set an environment variable named API_KEY with your ExchangeRate API key.
