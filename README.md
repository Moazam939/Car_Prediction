🚗 Car Price Prediction App
A mobile application that predicts the resale price of a car based on user input. The project consists of three main components:

🔬 Machine Learning Model using Polynomial Regression
🌐 REST API built with Flask
📱 Android App using Kotlin + Jetpack Compose + Retrofit

📊 1. Model Training (Polynomial Regression)
The machine learning model was trained using a dataset of used cars.
Features include:
Car Name
Year
Present Price
KMs Driven
Owner Count
Fuel Type
Seller Type
Transmission Type

The model uses Polynomial Regression to improve accuracy for non-linear price patterns.
Model accuracy is 97.49.
Train Score: 0.9851715579765139
Test Score: 0.9749149576056115
After training, the model was saved using joblib or pickle.
✅ Notebook and training script are located in the model/ folder (if applicable).

🧪 2. REST API (Flask)
A lightweight Flask server was built to serve the model.
Exposes a /predict endpoint which accepts POST requests with JSON payload:
json
{
  "year": 2014,
  "present_price": 5.6,
  "driven_kms": 75000,
  "owner": 0,
  "car_name": "Swift",
  "fuel_type": "Petrol",
  "selling_type": "Dealer",
  "transmission": "Manual"
}
Returns:
{
  "prediction": 3.45
}
The Flask app must be hosted on a local or public server for the Android app to consume.

📱 3. Android App (Kotlin + Jetpack Compose)
Built using Jetpack Compose for a modern, declarative UI.
Uses Retrofit for making HTTP calls to the Flask backend.
Users enter car details via UI components like OutlinedTxtField and DropdownMenu.
Predictions are fetched and displayed dynamically on the screen.
Key Features:
Intuitive form-based UI
Real-time price prediction
Dropdowns for categorical fields
Error handling for invalid inputs

🛠 Technologies Used
Layer	Tech Stack
ML Model	Python, Pandas, Scikit-learn
API Backend	Flask, Gunicorn (optional)
Android App	Kotlin, Jetpack Compose, Retrofit
Communication	REST API (JSON)

Graph
<img width="562" height="455" alt="predict_graph" src="https://github.com/user-attachments/assets/c9171b6c-1ae7-4450-86c1-c48735baae77" />

App ui Image:
<img width="189" height="410" alt="car_prediction_app" src="https://github.com/user-attachments/assets/bca53c40-cf7a-4a88-9e06-68a55268dea7" />


