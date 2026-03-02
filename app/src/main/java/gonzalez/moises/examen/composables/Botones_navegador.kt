package gonzalez.moises.examen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun App_principal()
{
    var estado by remember { mutableStateOf(1) }
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = estado == 1,
                    onClick = {estado = 1},
                    icon = { Icon(Icons.Default.Home, contentDescription = "Cursos")},
                    label = { Text("Cursos") }
                )
                NavigationBarItem(
                    selected = estado == 0,
                    onClick = {estado = 0},
                    icon = { Icon(Icons.Default.Person, contentDescription = "Yo")},
                    label = { Text("Yo") }
                )

            }
        }
    ) {innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween )
        {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Onion Math", fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            if (estado == 0)
            {
                PantallaPerfil()
            } else {
                Cursos_pantalla()
            }
            Box(modifier = Modifier.fillMaxWidth())
            {
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                }
            }
        }
    }
}

