# Polinomen backend

Backend for Polinomen, an application for creation and management of personal word dictionaries.

## How to run

1. Populate `src/main/resources/application.properties` with your database connection data.
2. Generate a pair of RSA keys for JWT encryption and decryption at `src/main/resources`.
3. Upon initializing the DB schema, set the `seed.enabled` flag to true, then set it back to false.
4. Run the application. Use an HTTP client of your choice to run the requests.
