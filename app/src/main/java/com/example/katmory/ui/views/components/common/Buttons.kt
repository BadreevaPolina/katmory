import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.katmory.R
import com.example.katmory.ui.views.components.theme.fontFamily


@Composable
fun TypeGameButton(
    icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(vertical = 16.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(colorResource(R.color.main_pink))
            .fillMaxWidth(fraction = 0.8f)
            .height(90.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp)
            )
            Text(
                text,
                fontSize = 28.sp,
                fontFamily = fontFamily,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(10.dp),
            )
        }
    }
}


@Composable
fun ContinueButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 5.dp, bottom = 15.dp)
            .height(70.dp)
            .clickable { onClick() }
            .drawBehind {
                drawOval(
                    color = (Color(0xFFEECFD0)),
                    size = Size(size.width, size.height)
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.button),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Продолжить",
            fontSize = 24.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }
}


@Composable
fun SmallContinueButton(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(50.dp)
            .clickable { onClick() }
            .drawBehind {
                drawOval(
                    color = Color(0xFFEECFD0),
                    size = Size(size.width, size.height)
                )},
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.button),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            text = "Продолжить",
            fontSize = 16.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }
}
