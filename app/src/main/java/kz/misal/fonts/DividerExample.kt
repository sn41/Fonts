package kz.misal.fonts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DividerExample() {
    Row(

        modifier = Modifier
            .fillMaxWidth()

            // Ключевой момент: Row примет высоту самого высокого элемента
            // Без этого VerticalDivider растянется на весь экран!!!!!!!!!
            .height(IntrinsicSize.Min)

            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "34",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.alignByBaseline()
        )


        VerticalDivider(
            // Разделитель теперь знает, до каких пор ему растягиваться при fillMaxHeight
            modifier = Modifier.fillMaxHeight().padding(vertical = 4.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )

        Text(
            text = "градуса в Темиртау",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.alignByBaseline()
        )
    }
}