package com.example.composeapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import kotlinx.coroutines.NonDisposableHandle.parent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            topAppBar()

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(){

    Scaffold(
        topBar = {TopAppBarCompose()},
    ) {

Column(modifier = Modifier.padding(it),

    content = {
MainContent()
    })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarCompose() {
    TopAppBar(
        title = { Text(text = "Smart Switch",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            modifier = Modifier.padding(start = 20.dp)
        )},
        navigationIcon = {},
        actions = {},
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
    )
}

@Composable
fun MainContent(){

    Surface {
        Column {
            Surface(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.085f), color = Color.LightGray) {
            }
        }

       
        ConstraintLayout( Modifier.fillMaxSize()) {

            val (sendBtn, receiveBtn, bottomIcon) = createRefs()

            Image(painterResource(id = R.drawable.receive),contentDescription = "receive",
            modifier = Modifier.constrainAs(receiveBtn){
               bottom.linkTo(sendBtn.top)
               centerHorizontallyTo(parent)
            })


            Image(painterResource(id = R.drawable.send),contentDescription = "send",
                modifier = Modifier.constrainAs(sendBtn){
                    centerHorizontallyTo(parent)
                    centerHorizontallyTo(parent)
                    top.linkTo(receiveBtn.top)
                    bottom.linkTo(bottomIcon.top)
                })

            Image(painterResource(id = R.drawable.bottom_icon), contentDescription = "send",
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .constrainAs(bottomIcon) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    })

        }
    }

}


