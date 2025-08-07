package com.example.carprediction.Screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import com.example.carprediction.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carprediction.models.request
import com.example.carprediction.viewmodels.View_Model

@Composable
fun home(modifier: Modifier = Modifier) {
    val viewModel: View_Model = viewModel()
    val prediction = viewModel.ui_state.observeAsState()
    val predictionValue = prediction.value?.prediction ?: 0.0

    // State for user inputs
    var year by rememberSaveable { mutableStateOf("") }
    var price by rememberSaveable { mutableStateOf("") }
    var kms by rememberSaveable { mutableStateOf("") }
    var owner by rememberSaveable { mutableStateOf("") }

    var carName by rememberSaveable { mutableStateOf("") }

    var fuelType by rememberSaveable { mutableStateOf("Petrol") }
    val fuelOptions = listOf("Petrol", "Diesel")

    var sellerType by rememberSaveable { mutableStateOf("Dealer") }
    val sellerOptions = listOf("Dealer", "Individual")

    var transmission by rememberSaveable { mutableStateOf("Manual") }
    val transmissionOptions = listOf("Manual", "Automatic")

    val verticalscroll = rememberScrollState()

    Box(modifier = Modifier.fillMaxSize())
    {

        Image(
            painter = painterResource(id = R.drawable.car_back), // replace with your image resource
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .systemBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(0.dp)
                    .background(color = androidx.compose.ui.graphics.Color.Black)
                    .padding(20.dp)
            ) {
                Text(
                    text = "Car Price Prediction", style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            // --- INPUT FIELDS ---
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(10.dp)
                    .background(
                    color = Color.White.copy(alpha = 0.5f), // semi-transparent background
                    shape = RoundedCornerShape(16.dp)
                )
                    .padding(10.dp)
                    .verticalScroll(verticalscroll),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = carName,
                    onValueChange = { carName = it },
                    label = { Text("Car Name",
                        color =  Color.Black,
                        fontWeight = FontWeight.SemiBold) },
                    modifier = Modifier.fillMaxWidth()
                        .padding(5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black
                    )
                )
                OutlinedTextField(
                    value = year,
                    onValueChange = { year = it },
                    label = { Text("Year",
                        color =  Color.Black,
                        fontWeight = FontWeight.SemiBold) },
                    modifier = Modifier.fillMaxWidth()
                        .padding(5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black
                    )
                )
                OutlinedTextField(
                    value = price,
                    onValueChange = { price = it },
                    label = { Text("Present Price",
                        color =  Color.Black,
                        fontWeight = FontWeight.SemiBold) },
                    modifier = Modifier.fillMaxWidth()
                        .padding(5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black
                    )
                )
                OutlinedTextField(
                    value = kms,
                    onValueChange = { kms = it },
                    label = { Text("Driven KMs",
                        color =  Color.Black,
                        fontWeight = FontWeight.SemiBold) },
                    modifier = Modifier.fillMaxWidth()
                        .padding(5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black
                    )
                )
                OutlinedTextField(
                    value = owner,
                    onValueChange = { owner = it },
                    label = { Text("Owner Count",
                        color =  Color.Black,
                        fontWeight = FontWeight.SemiBold) },
                    modifier = Modifier.fillMaxWidth()
                        .padding(5.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black,
                        cursorColor = Color.Black,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black
                    )
                )
//        // --- DROPDOWNS ---
                DropdownField(label = "Fuel Type",
                    selected = fuelType,
                    options = fuelOptions) {
                    fuelType = it
                }

                DropdownField(
                    label = "Seller Type",
                    selected = sellerType,
                    options = sellerOptions
                ) {
                    sellerType = it
                }

                DropdownField(
                    label = "Transmission",
                    selected = transmission,
                    options = transmissionOptions
                ) {
                    transmission = it
                }

                // --- SUBMIT BUTTON ---
                Button(
                    onClick = {
                        if (year.isNotEmpty() && price.isNotEmpty() && kms.isNotEmpty() && owner.isNotEmpty()) {
                            val requestData = request(
                                year = year.toInt(),
                                present_price = price.toDouble(),
                                driven_kms = kms.toInt(),
                                owner = owner.toInt(),
                                car_name = carName,
                                fuel_type = fuelType,
                                selling_type = sellerType,
                                transmission = transmission
                            )
                            viewModel.car_predict_price(requestData)

//                   year = ""
//                   price = ""
//                   kms = ""
//                   owner = ""
//                   carName = ""
//                   fuelType = ""
//                   sellerType = ""
//                   transmission = ""

                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(10.dp)
                        .border(2.dp, Color.Black, shape = RoundedCornerShape(20.dp)),
                    colors = ButtonColors(
                        containerColor = Color.Transparent.copy(0.3f),
                        contentColor = Color.White,
                        disabledContainerColor = Color.Gray.copy(0.3f),
                        disabledContentColor = Color.LightGray
                    )
                ) {
//                    Icon(Icons.Default.Send, contentDescription = "Predict")
//                    Spacer(Modifier.width(8.dp))
                    Text("Predict Price")
                }

                // --- RESULT ---
                Spacer(Modifier.height(20.dp))

//        Text(text = "Predicted Price: ₹$predictionValue Lakh")
                AnimatedVisibility(visible = true) {
                    Text(
                        text = "Predicted Price: ₹$predictionValue Lakh",
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                    )
                }
            }
        }
    }
}
@Composable
fun DropdownField(
    label: String,
    selected: String,
    options: List<String>,
    onSelected: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            label = { Text(label,
                color =  Color.Black,
                fontWeight = FontWeight.SemiBold) },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
                .padding(5.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                cursorColor = Color.Black,
                focusedTextColor = Color.Black.copy(1f),
                unfocusedTextColor = Color.Black.copy(0.1f),
                focusedLabelColor = Color.Black,
                unfocusedLabelColor = Color.Black
            ),
            trailingIcon = {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}

