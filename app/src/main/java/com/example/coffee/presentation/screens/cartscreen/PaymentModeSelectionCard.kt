package com.example.coffee.presentation.screens.cartscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffee.R
import com.example.coffee.presentation.ui.theme.LightBrown
import java.util.Locale

@Composable
fun PaymentModeSelectionCard(totalAmount: Double) {
    var expanded by remember { mutableStateOf(false) }
    var selectedWay by remember { mutableStateOf("微信支付") }
    val payWay = listOf("微信支付", "支付宝支付")
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(
                            if (selectedWay == "微信支付") R.drawable.wxzf_logo
                            else R.drawable.zfb_logo
                        ),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = selectedWay,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = String.format(Locale.US, "%.1f 元", totalAmount),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.SemiBold, color = LightBrown
                            )
                        )
                    }
                }
                Box {
                    Icon(
                        painter = painterResource(R.drawable.arrow_down),
                        contentDescription = "更改支付方式",
                        modifier = Modifier.size(30.dp).clickable{expanded = true}
                    )
                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        payWay.forEach { way ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = way,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                },
                                onClick = {
                                    selectedWay = way
                                    expanded = false
                                },
                                leadingIcon = {
                                    Image(
                                        painter = painterResource(
                                            if (way == "微信支付") R.drawable.wxzf_logo
                                            else R.drawable.zfb_logo
                                        ),
                                        contentDescription = if (way == "微信支付") "微信支付" else "支付宝支付",
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                modifier = Modifier
                                    .padding(4.dp)
                                    .background(
                                        color = if (selectedWay == way) LightBrown.copy(
                                            alpha = 0.15f
                                        ) else Color.Transparent
                                    )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBrown,
                    contentColor = Color.White
                )
            ) {
                Text(text = "确认支付", fontSize = 18.sp)
            }
        }
    }
}
