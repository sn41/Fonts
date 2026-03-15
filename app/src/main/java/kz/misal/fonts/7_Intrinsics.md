Когда в `Row` находятся элементы разной высоты (например, крупный заголовок и мелкий текст), обычный `VerticalDivider` может вести себя непредсказуемо: либо растянуться на весь экран, либо сжаться в точку.

Чтобы разделитель точно подстроился под высоту самого высокого соседа, нужно использовать **Intrinsics** (внутренние измерения).

### Решение через `IntrinsicSize.Min`

По умолчанию `Row` не знает высоты своих детей до того, как начнет их рисовать. Модификатор `height(IntrinsicSize.Min)` заставляет `Row` сначала вычислить минимальную высоту, необходимую для отображения всех элементов, а затем закрепить её. После этого `fillMaxHeight()` у разделителя будет работать корректно.

```kotlin
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*

@Composable
fun DividerExample() {
    Row(
        // Ключевой момент: Row примет высоту самого высокого элемента
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min) 
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "34",
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.alignByBaseline()
        )

        // Разделитель теперь знает, до каких пор ему растягиваться
        VerticalDivider(
            modifier = Modifier.fillMaxHeight().padding(vertical = 4.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant
        )

        Text(
            text = "градуса в Темиртау",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.alignByBaseline()
        )
    }
}

```

---

### Тонкие настройки (Tips & Tricks)

1. **Отступы разделителя**: Если вы не хотите, чтобы линия касалась границ текста, используйте `.padding(vertical = ...)` прямо на `VerticalDivider`. Поскольку у нас включен `fillMaxHeight()`, паддинг просто «подрежет» линию сверху и снизу.
2. **Выравнивание по Baseline**: Обратите внимание, что в примере выше я добавил `alignByBaseline()`. Это гарантирует, что число "34" и текст после разделителя будут стоять на одной линии, даже если разделитель их визуально разделяет.
3. **Если элементов много**: `IntrinsicSize.Min` — операция чуть более тяжелая, чем обычная отрисовка, так как она требует двойного прохода измерений. В простых строках это незаметно, но в огромных списках (LazyColumn) старайтесь не злоупотреблять этим, если можно задать фиксированную высоту.

---

### А если нужно сместить разделитель?

Иногда дизайн требует, чтобы разделитель был не по центру, а, скажем, прижат к нижней границе текста. В таком случае вместо `VerticalDivider` можно использовать обычный `Box`:

```kotlin
Box(
    modifier = Modifier
        .width(1.dp)
        .fillMaxHeight(0.6f) // Займет только 60% высоты строки
        .background(Color.Gray)
        .align(Alignment.Bottom) // Прижмется к низу
)

```

Хотите, я помогу собрать этот код в готовый переиспользуемый компонент «Ячейка с разделителем»?