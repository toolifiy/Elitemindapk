package com.example

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import android.graphics.Paint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.key
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Extension
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MilitaryTech
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.icons.outlined.Leaderboard
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Psychology
import androidx.compose.material.icons.outlined.SportsEsports
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.material.icons.filled.Grain
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.graphics.StrokeCap
import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import kotlinx.coroutines.delay
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.CyberBackground
import com.example.ui.theme.CyberCardBorder
import com.example.ui.theme.CyberSurface
import com.example.ui.theme.CyberSurfaceVariant
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.NeonBlue
import com.example.ui.theme.NeonCyan
import com.example.ui.theme.NeonGold
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.NeonPurple
import com.example.ui.theme.NeonPurpleBright
import com.example.ui.theme.NeonYellow
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

// 🎵 Relaxing Background Music Audio Synthesizer Engine
object RelaxingBgmPlayer {
    private var audioTrack: AudioTrack? = null
    private var isPlaying = false
    private var bgmThread: Thread? = null
    var isBgmEnabled = true
    var volume = 0.7f

    fun startBgm() {
        if (!isBgmEnabled || isPlaying) return
        isPlaying = true

        bgmThread = Thread {
            val sampleRate = 22050
            val minBufferSize = AudioTrack.getMinBufferSize(
                sampleRate,
                AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT
            )

            try {
                audioTrack = AudioTrack.Builder()
                    .setAudioAttributes(
                        AudioAttributes.Builder()
                            .setUsage(AudioAttributes.USAGE_GAME)
                            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                            .build()
                    )
                    .setAudioFormat(
                        AudioFormat.Builder()
                            .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                            .setSampleRate(sampleRate)
                            .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                            .build()
                    )
                    .setBufferSizeInBytes(if (minBufferSize > 0) minBufferSize * 2 else 4096)
                    .setTransferMode(AudioTrack.MODE_STREAM)
                    .build()

                audioTrack?.play()

                val bufferSize = 1024
                val buffer = ShortArray(bufferSize)

                // Ultra-relaxing Ambient Warm Chords (Cmaj9, Fmaj9, Am7, G6)
                val chords = listOf(
                    doubleArrayOf(130.81, 164.81, 196.00, 246.94, 293.66), // Cmaj9
                    doubleArrayOf(87.31, 130.81, 164.81, 220.00, 261.63),  // Fmaj9
                    doubleArrayOf(110.00, 130.81, 164.81, 196.00, 261.63), // Am7
                    doubleArrayOf(98.00, 123.47, 146.83, 164.81, 220.00)   // G6
                )

                var sampleIndex = 0L
                var chordIdx = 0
                val chordDurationSamples = sampleRate * 5

                val chimeNotes = doubleArrayOf(523.25, 659.25, 783.99, 987.77, 1046.50)
                var currentChimeFreq = 0.0
                var chimeSampleStart = 0L

                while (isPlaying) {
                    val currentVol = volume.coerceIn(0f, 1f)
                    for (i in 0 until bufferSize) {
                        val currentSample = sampleIndex++
                        val chordSampleTime = (currentSample % chordDurationSamples)

                        if (chordSampleTime == 0L) {
                            chordIdx = (chordIdx + 1) % chords.size
                        }

                        if (currentSample % (sampleRate * 3.5).toInt() == 0L) {
                            currentChimeFreq = chimeNotes.random()
                            chimeSampleStart = currentSample
                        }

                        val progress = chordSampleTime.toDouble() / chordDurationSamples
                        val envelope = Math.sin(progress * Math.PI)

                        val activeChord = chords[chordIdx]
                        var sampleVal = 0.0

                        for (freq in activeChord) {
                            val phase = 2.0 * Math.PI * freq * currentSample / sampleRate
                            val sine = Math.sin(phase)
                            val sub = Math.sin(phase * 0.5) * 0.25
                            sampleVal += (sine + sub)
                        }
                        sampleVal = (sampleVal / activeChord.size) * envelope * 0.35

                        if (currentChimeFreq > 0.0) {
                            val chimeTime = (currentSample - chimeSampleStart) / sampleRate.toDouble()
                            if (chimeTime < 1.8) {
                                val chimeEnv = Math.exp(-chimeTime * 3.0)
                                val chimeWave = Math.sin(2.0 * Math.PI * currentChimeFreq * currentSample / sampleRate)
                                sampleVal += chimeWave * chimeEnv * 0.12
                            } else {
                                currentChimeFreq = 0.0
                            }
                        }

                        val finalShort = (sampleVal * 32767.0 * currentVol * 0.6).toInt().coerceIn(-32768, 32767)
                        buffer[i] = finalShort.toShort()
                    }

                    audioTrack?.write(buffer, 0, bufferSize)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                try {
                    audioTrack?.stop()
                    audioTrack?.release()
                } catch (e: Exception) { }
                audioTrack = null
            }
        }
        bgmThread?.start()
    }

    fun stopBgm() {
        isPlaying = false
        bgmThread = null
    }

    fun setEnabled(enabled: Boolean) {
        isBgmEnabled = enabled
        if (!enabled) {
            stopBgm()
        }
    }
}

class MainActivity : ComponentActivity() {
    @OptIn(androidx.compose.foundation.ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val configuration = androidx.compose.ui.platform.LocalConfiguration.current
            val currentDensity = androidx.compose.ui.platform.LocalDensity.current
            val screenWidthDp = configuration.screenWidthDp
            val targetWidthDp = 390f
            val scaleFactor = if (screenWidthDp in 1..389) {
                (screenWidthDp.toFloat() / targetWidthDp).coerceIn(0.80f, 1.0f)
            } else {
                1.0f
            }
            val adaptiveDensity = androidx.compose.ui.unit.Density(
                density = currentDensity.density * scaleFactor,
                fontScale = (currentDensity.fontScale * scaleFactor).coerceAtMost(1.05f)
            )
            androidx.compose.runtime.CompositionLocalProvider(
                androidx.compose.foundation.LocalOverscrollConfiguration provides null,
                androidx.compose.ui.platform.LocalDensity provides adaptiveDensity
            ) {
                MyApplicationTheme {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val context = LocalContext.current
    var showSettingsDialog by remember { mutableStateOf(false) }
    var showMathGameDialog by remember { mutableStateOf(false) }
    var showMemoryGameDialog by remember { mutableStateOf(false) }
    var showReactionGameDialog by remember { mutableStateOf(false) }
    var showDotConnectGameDialog by remember { mutableStateOf(false) }
    var showTicTacToeGameDialog by remember { mutableStateOf(false) }
    var reactionInitialGame by remember { mutableStateOf("SPEED_REFLEX") }
    var selectedCategoryView by remember { mutableStateOf<String?>(null) }
    var selectedTab by remember { mutableStateOf("HOME") }

    // User Energy Tokens state (Initial 20 Tokens Free)
    var userTokens by rememberSaveable { mutableIntStateOf(20) }
    var showOutOfTokensDialog by remember { mutableStateOf(false) }

    // User Profile persistent state
    val profilePrefs = remember { context.getSharedPreferences("user_profile_prefs", Context.MODE_PRIVATE) }
    var userName by remember { mutableStateOf(profilePrefs.getString("user_name", "Sameer Choudhary") ?: "Sameer Choudhary") }
    var userBio by remember { mutableStateOf(profilePrefs.getString("user_bio", "🧠 Cyber Mind Gamer") ?: "🧠 Cyber Mind Gamer") }
    var userEmoji by remember { mutableStateOf(profilePrefs.getString("user_emoji", "👑") ?: "👑") }

    fun updateProfile(newName: String, newBio: String, newEmoji: String) {
        userName = newName
        userBio = newBio
        userEmoji = newEmoji
        profilePrefs.edit()
            .putString("user_name", newName)
            .putString("user_bio", newBio)
            .putString("user_emoji", newEmoji)
            .apply()
    }

    // Helper to start a game by deducting 1 token or showing out-of-tokens alert
    val tryStartGame: (() -> Unit) -> Unit = { action ->
        if (userTokens > 0) {
            userTokens--
            action()
        } else {
            showOutOfTokensDialog = true
        }
    }

    // Game history state
    val gameHistory = remember {
        mutableStateListOf<GameHistoryRecord>()
    }

    val showSoonToast = {
        Toast.makeText(context, "This will work soon", Toast.LENGTH_SHORT).show()
    }

    if (showOutOfTokensDialog) {
        AlertDialog(
            onDismissRequest = { showOutOfTokensDialog = false },
            containerColor = CyberSurface,
            titleContentColor = TextPrimary,
            textContentColor = TextSecondary,
            title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.FlashOn,
                        contentDescription = null,
                        tint = NeonYellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("NO TOKENS LEFT!", fontWeight = FontWeight.Black, color = TextPrimary, fontSize = 18.sp)
                }
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        "You have 0/20 tokens remaining. Starting a game costs 1 token.",
                        color = TextPrimary,
                        fontSize = 14.sp
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = { showOutOfTokensDialog = false },
                    colors = ButtonDefaults.buttonColors(containerColor = CyberSurfaceVariant)
                ) {
                    Text("OK", color = TextPrimary, fontWeight = FontWeight.Bold)
                }
            }
        )
    }

    if (showSettingsDialog) {
        GameSettingsDialog(onDismiss = { showSettingsDialog = false })
    }

    if (showMathGameDialog) {
        MathGameDialog(
            onDismiss = { showMathGameDialog = false },
            onGameFinished = { record ->
                gameHistory.add(0, record)
            }
        )
    }

    if (showMemoryGameDialog) {
        MemoryGameDialog(
            onDismiss = { showMemoryGameDialog = false },
            onGameFinished = { record ->
                gameHistory.add(0, record)
            }
        )
    }

    if (showReactionGameDialog) {
        ReactionGameDialog(
            onDismiss = { showReactionGameDialog = false },
            onGameFinished = { record ->
                gameHistory.add(0, record)
            },
            initialSubGame = reactionInitialGame
        )
    }

    if (showDotConnectGameDialog) {
        DotConnectGameDialog(
            onDismiss = { showDotConnectGameDialog = false },
            onGameFinished = { record ->
                gameHistory.add(0, record)
            }
        )
    }

    if (showTicTacToeGameDialog) {
        TicTacToeGameDialog(
            onDismiss = { showTicTacToeGameDialog = false },
            onGameFinished = { record ->
                gameHistory.add(0, record)
            }
        )
    }

    Scaffold(
        containerColor = CyberBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            BottomNavBar(
                selectedTab = selectedTab,
                onTabClick = { tab ->
                    selectedTab = tab
                    selectedCategoryView = null
                    if (tab != "HOME" && tab != "GAMES" && tab != "PROGRESS" && tab != "BATTLE" && tab != "PROFILE") {
                        showSoonToast()
                    }
                }
            )
        }
    ) { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val screenWidth = maxWidth
            val screenHeight = maxHeight
            val isCompactWidth = screenWidth < 360.dp
            val isCompactHeight = screenHeight < 640.dp

            val adaptiveHorizontalPadding = if (isCompactWidth) 10.dp else 16.dp
            val adaptiveVerticalPadding = if (isCompactHeight) 4.dp else 6.dp
            val adaptiveItemSpacing = if (isCompactHeight) 8.dp else 10.dp

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.statusBars)
                    .verticalScroll(rememberScrollState())
                    .padding(vertical = adaptiveVerticalPadding),
                verticalArrangement = Arrangement.spacedBy(adaptiveItemSpacing)
            ) {
                // Top Bar
                TopBarSection(
                    horizontalPadding = adaptiveHorizontalPadding,
                    onClick = { selectedTab = "PROFILE" },
                    onSettingsClick = { showSettingsDialog = true },
                    tokens = userTokens,
                    onTokensClick = {
                        Toast.makeText(context, "⚡ Tokens: $userTokens/20 available (1 Token per game)", Toast.LENGTH_SHORT).show()
                    },
                    userName = userName,
                    userEmoji = userEmoji
                )

                if (selectedCategoryView != null) {
                    // Category-Specific Games Interface View with Swipeable Games Carousel
                    Box(modifier = Modifier.padding(horizontal = adaptiveHorizontalPadding)) {
                        CategoryGamesInterface(
                            categoryKey = selectedCategoryView!!,
                            onBackClick = { selectedCategoryView = null },
                            onPlayReactionSpeed = {
                                tryStartGame {
                                    reactionInitialGame = "SPEED_REFLEX"
                                    showReactionGameDialog = true
                                }
                            },
                            onPlayArrowClick = {
                                tryStartGame {
                                    reactionInitialGame = "ARROW_CLICK"
                                    showReactionGameDialog = true
                                }
                            },
                            onPlayMemoryGame = {
                                tryStartGame { showMemoryGameDialog = true }
                            },
                            onPlayMathGame = {
                                tryStartGame { showMathGameDialog = true }
                            },
                            onPlayDotConnect = {
                                tryStartGame { showDotConnectGameDialog = true }
                            },
                            onPlayTicTacToe = {
                                tryStartGame { showTicTacToeGameDialog = true }
                            }
                        )
                    }
                } else {
                    when (selectedTab) {
                        "PROFILE" -> {
                            // Dedicated Profile Screen View
                            Box(modifier = Modifier.padding(horizontal = adaptiveHorizontalPadding)) {
                                ProfileTabScreen(
                                    userName = userName,
                                    userBio = userBio,
                                    userEmoji = userEmoji,
                                    onSaveProfile = { newName, newBio, newEmoji ->
                                        updateProfile(newName, newBio, newEmoji)
                                    },
                                    onPlayMathGame = { tryStartGame { showMathGameDialog = true } },
                                    onOpenSettings = { showSettingsDialog = true },
                                    gameHistory = gameHistory
                                )
                            }
                        }
                        "BATTLE" -> {
                            // Dedicated 2-Player Battle Arena View
                            Box(modifier = Modifier.padding(horizontal = adaptiveHorizontalPadding)) {
                                BattleTabScreen(
                                    onSaveBattleHistory = { record ->
                                        gameHistory.add(0, record)
                                    },
                                    onTryStartGame = tryStartGame
                                )
                            }
                        }
                        "PROGRESS" -> {
                            // Dedicated Progress & Saved History View
                            Box(modifier = Modifier.padding(horizontal = adaptiveHorizontalPadding)) {
                                ProgressTabScreen(
                                    gameHistory = gameHistory,
                                    onPlayMathGame = { tryStartGame { showMathGameDialog = true } }
                                )
                            }
                        }
                        "GAMES" -> {
                            // Dedicated Games View when GAMES tab is selected
                            GamesInterfaceSection(
                                horizontalPadding = adaptiveHorizontalPadding,
                                onClick = showSoonToast,
                                onMathClick = { tryStartGame { showMathGameDialog = true } },
                                onMemoryClick = { tryStartGame { showMemoryGameDialog = true } },
                                onReactionClick = {
                                    tryStartGame {
                                        reactionInitialGame = "SPEED_REFLEX"
                                        showReactionGameDialog = true
                                    }
                                },
                                onArrowClick = {
                                    tryStartGame {
                                        reactionInitialGame = "ARROW_CLICK"
                                        showReactionGameDialog = true
                                    }
                                },
                                onDotConnectClick = {
                                    tryStartGame { showDotConnectGameDialog = true }
                                },
                                onTicTacToeClick = {
                                    tryStartGame { showTicTacToeGameDialog = true }
                                },
                                onCategoryClick = { categoryKey ->
                                    selectedCategoryView = categoryKey
                                }
                            )
                        }
                        else -> {
                            // 1. Level Progress Fillbar Card
                            LevelProgressCard(
                                horizontalPadding = adaptiveHorizontalPadding,
                                onClick = { selectedTab = "PROGRESS" }
                            )

                            // 2. Swipeable Offer Banners Carousel
                            OfferBannersCarousel(
                                horizontalPadding = adaptiveHorizontalPadding,
                                onClick = { tryStartGame { showMathGameDialog = true } }
                            )

                            // Brain Games Section Grid
                            TrainYourBrainSection(
                                horizontalPadding = adaptiveHorizontalPadding,
                                onClick = showSoonToast,
                                onMathClick = { tryStartGame { showMathGameDialog = true } },
                                onMemoryClick = { tryStartGame { showMemoryGameDialog = true } },
                                onReactionClick = {
                                    tryStartGame {
                                        reactionInitialGame = "SPEED_REFLEX"
                                        showReactionGameDialog = true
                                    }
                                },
                                onDotConnectClick = {
                                    tryStartGame { showDotConnectGameDialog = true }
                                },
                                onTicTacToeClick = {
                                    tryStartGame { showTicTacToeGameDialog = true }
                                },
                                onCategoryClick = { categoryKey ->
                                    selectedCategoryView = categoryKey
                                }
                            )

                            // Daily Challenge Section
                            DailyChallengeCard(
                                horizontalPadding = adaptiveHorizontalPadding,
                                onClick = { tryStartGame { showMathGameDialog = true } }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun TopBarSection(
    horizontalPadding: androidx.compose.ui.unit.Dp = 16.dp,
    onClick: () -> Unit,
    onSettingsClick: () -> Unit = onClick,
    tokens: Int = 20,
    onTokensClick: () -> Unit = {},
    userName: String = "Sameer Choudhary",
    userEmoji: String = "👑"
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding, vertical = 0.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // User Profile & Badge
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .clickable { onClick() }
                .padding(2.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.linearGradient(
                            listOf(NeonPurple, NeonCyan)
                        )
                    )
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .background(CyberSurface),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = userEmoji,
                        fontSize = 20.sp
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = userName,
                    color = TextPrimary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        // Energy & Settings
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Energy Pill
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(CyberSurfaceVariant)
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(20.dp))
                    .clickable { onTokensClick() }
                    .padding(horizontal = 10.dp, vertical = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.FlashOn,
                    contentDescription = "Energy Icon",
                    tint = NeonYellow,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "$tokens/20",
                    color = TextPrimary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = " +",
                    color = NeonPurpleBright,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Settings Gear Icon
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(CyberSurfaceVariant)
                    .border(1.dp, CyberCardBorder, CircleShape)
                    .clickable { onSettingsClick() }
                    .testTag("settings_button"),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = TextSecondary,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
    }
}

@Composable
fun LevelProgressCard(
    horizontalPadding: androidx.compose.ui.unit.Dp = 16.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 1.dp,
                    color = CyberCardBorder,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable { onClick() }
                .testTag("level_progress_card"),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(NeonGold.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "👑", fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Lv. 0",
                        color = NeonGold,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "• Beginner",
                        color = TextSecondary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Text(
                    text = "0 / 1,000 XP",
                    color = NeonCyan,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Custom Softer Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFF1E222A))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.05f)
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(NeonGreen)
                )
            }
        }
    }
}
}

@Composable
fun OfferBannersCarousel(
    horizontalPadding: androidx.compose.ui.unit.Dp = 16.dp,
    onClick: () -> Unit
) {
    val listState = rememberLazyListState()
    val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "SPECIAL QUESTS & OFFERS",
                color = TextPrimary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )
            Text(
                text = "Swipe >",
                color = NeonCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        LazyRow(
            state = listState,
            flingBehavior = snapFlingBehavior,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = horizontalPadding)
        ) {
            // Quest Banner 1: STARTER QUEST (from screenshot style)
            item {
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(145.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .border(1.dp, Color(0xFF2E323D), RoundedCornerShape(18.dp))
                        .clickable { onClick() }
                        .testTag("starter_quest_banner"),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF181A20))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(14.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column {
                                Text(
                                    text = "0/3 COMPLETED",
                                    color = Color(0xFF63CC28),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 0.8.sp
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "STARTER ",
                                        color = TextPrimary,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "QUEST",
                                        color = Color(0xFF63CC28),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Text(
                                    text = "BY PLAYING 3 GAMES",
                                    color = TextMuted,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            // Glowing Loot Chest Graphic
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFF63CC28).copy(alpha = 0.15f))
                                    .border(1.dp, Color(0xFF63CC28).copy(alpha = 0.4f), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "📦", fontSize = 24.sp)
                            }
                        }

                        // Quest Timeline Nodes
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF22252F))
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            QuestNode(icon = "🧩", name = "PUZZLE", isDone = false)
                            Box(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(2.dp)
                                    .background(Color(0xFF383C4A))
                            )
                            QuestNode(icon = "🔢", name = "MATH", isDone = false)
                            Box(
                                modifier = Modifier
                                    .width(20.dp)
                                    .height(2.dp)
                                    .background(Color(0xFF383C4A))
                            )
                            QuestNode(icon = "🧠", name = "MEMORY", isDone = false)
                        }
                    }
                }
            }

            // Quest Banner 2: 1/2 DAYS STREAK BOOST (from screenshot style)
            item {
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(145.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .border(1.dp, Color(0xFF3D2C20), RoundedCornerShape(18.dp))
                        .clickable { onClick() }
                        .testTag("streak_banner"),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1714))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(14.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column {
                                Text(
                                    text = "1/2 DAYS STREAK",
                                    color = Color(0xFFCC6100),
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 0.8.sp
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "WIN 2X XP ",
                                        color = TextPrimary,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "REWARDS",
                                        color = Color(0xFFCC6100),
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Text(
                                    text = "Complete today's streak to earn themes!",
                                    color = TextMuted,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            // Glowing Flame Graphic
                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFCC6100).copy(alpha = 0.15f))
                                    .border(1.dp, Color(0xFFCC6100).copy(alpha = 0.4f), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "🔥", fontSize = 24.sp)
                            }
                        }

                        // Bottom Streak Badges
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF28201A))
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            StreakCardBadge(count = "12 🔥", label = "Bored")
                            StreakCardBadge(count = "13 🔥", label = "Sniff")
                            StreakCardBadge(count = "32 🔥", label = "Did it!")
                            StreakCardBadge(count = "245 🔥", label = "Let's play!")
                        }
                    }
                }
            }

            // Quest Banner 3: WIN CYBER NEON THEME
            item {
                Card(
                    modifier = Modifier
                        .width(300.dp)
                        .height(145.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .border(1.dp, Color(0xFF20323D), RoundedCornerShape(18.dp))
                        .clickable { onClick() }
                        .testTag("theme_offer_banner"),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF141A1F))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(14.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Top
                        ) {
                            Column {
                                Text(
                                    text = "SPECIAL OFFER • 0/1 UNLOCKED",
                                    color = NeonCyan,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    letterSpacing = 0.8.sp
                                )
                                Spacer(modifier = Modifier.height(3.dp))
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = "WIN CYBER ",
                                        color = TextPrimary,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "THEME",
                                        color = NeonCyan,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Text(
                                    text = "Finish 3 games today to claim neon dark UI!",
                                    color = TextMuted,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(NeonCyan.copy(alpha = 0.15f))
                                    .border(1.dp, NeonCyan.copy(alpha = 0.4f), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = "🎨", fontSize = 24.sp)
                            }
                        }

                        // Unlock Progress Bar
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xFF1B242C))
                                .padding(horizontal = 10.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Theme Reward Progress",
                                color = TextSecondary,
                                fontSize = 11.sp
                            )
                            Text(
                                text = "Claim Reward 🎁",
                                color = NeonCyan,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuestNode(icon: String, name: String, isDone: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape)
                .background(if (isDone) Color(0xFF63CC28) else Color(0xFF2E3340)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = icon, fontSize = 10.sp)
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = name,
            color = if (isDone) Color(0xFF63CC28) else TextSecondary,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun StreakCardBadge(count: String, label: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFF362A22))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = count,
            color = Color(0xFFCC6100),
            fontSize = 9.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

























@Composable
fun DailyChallengeCard(
    horizontalPadding: androidx.compose.ui.unit.Dp = 16.dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .clickable { onClick() }
                .testTag("daily_challenge_card"),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(NeonGold.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.TrackChanges,
                            contentDescription = "Daily Challenge",
                            tint = NeonGold,
                            modifier = Modifier.size(26.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "DAILY CHALLENGE",
                            color = TextPrimary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "5 Games • 10 Min",
                            color = TextSecondary,
                            fontSize = 12.sp
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            Brush.horizontalGradient(
                                listOf(NeonGold, Color(0xFFD97706))
                            )
                        )
                        .clickable { onClick() }
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "PLAY",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Today's Goal Progress Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(CyberSurfaceVariant)
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "TODAY'S GOAL",
                        color = NeonGreen,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "0/5 Games Completed",
                        color = TextPrimary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(CyberBackground)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.0f) // 0/5 = 0%
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(NeonPurpleBright, NeonCyan)
                                    )
                                )
                        )
                    }
                }

                Spacer(modifier = Modifier.width(12.dp))

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(NeonGold.copy(alpha = 0.15f))
                        .border(1.dp, NeonGold.copy(alpha = 0.4f), RoundedCornerShape(10.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Reward Chest",
                        tint = NeonGold,
                        modifier = Modifier.size(22.dp)
                    )
                }
            }
        }
    }
}
}

data class LeaderboardUser(
    val rank: Int,
    val name: String,
    val avatarEmoji: String,
    val xp: Int,
    val level: Int,
    val isUser: Boolean = false
)

@Composable
fun XpLeaderboardCard(
    currentUserName: String = "Sameer Choudhary",
    currentUserEmoji: String = "⚡"
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .border(1.dp, CyberCardBorder, RoundedCornerShape(20.dp))
            .testTag("xp_leaderboard_card"),
        colors = CardDefaults.cardColors(containerColor = CyberSurface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(NeonGold.copy(alpha = 0.2f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Leaderboard,
                            contentDescription = "Leaderboard",
                            tint = NeonGold,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "GLOBAL XP LEADERBOARD",
                            color = TextPrimary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                        Text(
                            text = "Top Players Ranked by XP",
                            color = TextSecondary,
                            fontSize = 11.sp
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(NeonGold.copy(alpha = 0.15f))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "GLOBAL",
                        color = NeonGold,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            HorizontalDivider(
                color = CyberCardBorder,
                thickness = 1.dp
            )

            // Notice: Placed below title row with correct English grammar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(NeonGold.copy(alpha = 0.12f))
                    .border(1.dp, NeonGold.copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "🔒 THIS FEATURE IS COMING SOON",
                        color = NeonGold,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.8.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Online multiplayer rankings & global leaderboards will be available in the upcoming update!",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
fun TechGridBackground(themeColor: Color) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height
        val gridSpacing = 16.dp.toPx()
        
        // Draw vertical lines
        var x = 0f
        while (x < width) {
            drawLine(
                color = themeColor.copy(alpha = 0.08f),
                start = androidx.compose.ui.geometry.Offset(x, 0f),
                end = androidx.compose.ui.geometry.Offset(x, height),
                strokeWidth = 1f
            )
            x += gridSpacing
        }
        
        // Draw horizontal lines
        var y = 0f
        while (y < height) {
            drawLine(
                color = themeColor.copy(alpha = 0.08f),
                start = androidx.compose.ui.geometry.Offset(0f, y),
                end = androidx.compose.ui.geometry.Offset(width, y),
                strokeWidth = 1f
            )
            y += gridSpacing
        }
        
        // Draw subtle tech concentric rings
        drawCircle(
            color = themeColor.copy(alpha = 0.05f),
            radius = 30.dp.toPx(),
            center = androidx.compose.ui.geometry.Offset(width / 2f, height / 2f),
            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1f)
        )
        drawCircle(
            color = themeColor.copy(alpha = 0.03f),
            radius = 50.dp.toPx(),
            center = androidx.compose.ui.geometry.Offset(width / 2f, height / 2f),
            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1f)
        )
    }
}

@Composable
fun ReactionGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)
        
        // Background ECG speed visual line
        Canvas(modifier = Modifier.fillMaxSize()) {
            val h = size.height
            val w = size.width
            val path = androidx.compose.ui.graphics.Path().apply {
                moveTo(10f, h / 2f)
                lineTo(w * 0.2f, h / 2f)
                lineTo(w * 0.25f, h * 0.3f)
                lineTo(w * 0.3f, h * 0.7f)
                lineTo(w * 0.35f, h / 2f)
                lineTo(w * 0.65f, h / 2f)
                lineTo(w * 0.7f, h * 0.2f)
                lineTo(w * 0.75f, h * 0.8f)
                lineTo(w * 0.8f, h / 2f)
                lineTo(w - 10f, h / 2f)
            }
            drawPath(
                path = path,
                color = themeColor.copy(alpha = 0.45f),
                style = androidx.compose.ui.graphics.drawscope.Stroke(
                    width = 2.dp.toPx(),
                    pathEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(12f, 12f))
                )
            )
            // Draw a bright speed circle node on the peak
            drawCircle(
                color = Color.White,
                radius = 3.5.dp.toPx(),
                center = androidx.compose.ui.geometry.Offset(w * 0.7f, h * 0.2f)
            )
            drawCircle(
                color = themeColor,
                radius = 6.dp.toPx(),
                center = androidx.compose.ui.geometry.Offset(w * 0.7f, h * 0.2f),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.5.dp.toPx())
            )
        }

        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left Badges - Neon stylized
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFFF3D00).copy(alpha = 0.25f))
                        .border(1.dp, Color(0xFFFF3D00), RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 3.dp)
                ) {
                    Text("🔥 STREAK 5", color = Color(0xFFFFD54F), fontSize = 8.sp, fontWeight = FontWeight.Black)
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(themeColor.copy(alpha = 0.25f))
                        .border(1.dp, themeColor.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 3.dp)
                ) {
                    Text("⚡ +500 XP", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Black)
                }
            }

            // Main central gauge with a thick ring and rotating arc feel
            Box(
                modifier = Modifier
                    .size(86.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            listOf(themeColor.copy(alpha = 0.35f), themeColor.copy(alpha = 0.05f), Color.Transparent)
                        )
                    )
                    .border(2.5.dp, themeColor, CircleShape)
                    .padding(3.dp),
                contentAlignment = Alignment.Center
            ) {
                // Outer dotted ring using Canvas
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color.White.copy(alpha = 0.3f),
                        radius = size.minDimension / 2f - 4f,
                        style = androidx.compose.ui.graphics.drawscope.Stroke(
                            width = 1.dp.toPx(),
                            pathEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(4f, 4f))
                        )
                    )
                }
                
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(CircleShape)
                        .background(Color.Black.copy(alpha = 0.4f))
                        .border(1.5.dp, themeColor.copy(alpha = 0.5f), CircleShape)
                        .padding(4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.FlashOn,
                            contentDescription = null,
                            tint = Color(0xFFFFD54F),
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = "142 ms",
                            color = Color.White,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }

            // Right Info Gauge
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFF00E676).copy(alpha = 0.25f))
                        .border(1.dp, Color(0xFF00E676), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text("GODLIKE", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Black)
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.Black.copy(alpha = 0.5f))
                        .padding(horizontal = 5.dp, vertical = 2.dp)
                ) {
                    Text("TOP 1%", color = themeColor, fontSize = 8.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun FocusGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)

        // Draw tactical HUD radar scans & angles
        Canvas(modifier = Modifier.fillMaxSize()) {
            val center = androidx.compose.ui.geometry.Offset(size.width / 2f, size.height / 2f)
            val r = 40.dp.toPx()
            
            // Outer scope cross lines
            drawLine(
                color = themeColor.copy(alpha = 0.45f),
                start = androidx.compose.ui.geometry.Offset(center.x - r - 30f, center.y),
                end = androidx.compose.ui.geometry.Offset(center.x + r + 30f, center.y),
                strokeWidth = 1.5.dp.toPx()
            )
            drawLine(
                color = themeColor.copy(alpha = 0.45f),
                start = androidx.compose.ui.geometry.Offset(center.x, center.y - r - 30f),
                end = androidx.compose.ui.geometry.Offset(center.x, center.y + r + 30f),
                strokeWidth = 1.5.dp.toPx()
            )
            
            // Nested dash circle for scope target calibration
            drawCircle(
                color = themeColor,
                radius = 35.dp.toPx(),
                style = androidx.compose.ui.graphics.drawscope.Stroke(
                    width = 1.dp.toPx(),
                    pathEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(6f, 6f))
                )
            )
            
            // Corner target bracket decorations (Sci-Fi look)
            val o = 45.dp.toPx()
            // Top Left corner bracket
            drawArc(
                color = themeColor,
                startAngle = 180f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = androidx.compose.ui.geometry.Offset(center.x - o, center.y - o),
                size = androidx.compose.ui.geometry.Size(o * 2, o * 2),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2.dp.toPx())
            )
            // Bottom Right corner bracket
            drawArc(
                color = themeColor,
                startAngle = 0f,
                sweepAngle = 90f,
                useCenter = false,
                topLeft = androidx.compose.ui.geometry.Offset(center.x - o, center.y - o),
                size = androidx.compose.ui.geometry.Size(o * 2, o * 2),
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2.dp.toPx())
            )
        }

        // Corner futuristic telemetry stats
        Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Row(modifier = Modifier.align(Alignment.TopStart), horizontalArrangement = Arrangement.spacedBy(3.dp)) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(3.dp))
                        .background(Color.Red)
                        .size(4.dp)
                        .align(Alignment.CenterVertically)
                )
                Text("REC: 1080P", color = Color.Red, fontSize = 7.sp, fontWeight = FontWeight.Black)
            }
            Text("LOCK ON 🎯", color = themeColor, fontSize = 8.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopEnd))
            Text("SCAN RATE: 240Hz", color = TextMuted, fontSize = 7.sp, modifier = Modifier.align(Alignment.BottomStart))
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(4.dp))
                    .background(themeColor.copy(alpha = 0.2f))
                    .padding(horizontal = 4.dp, vertical = 1.dp)
            ) {
                Text("ACC: 99.4%", color = themeColor, fontSize = 8.sp, fontWeight = FontWeight.Black)
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.radialGradient(
                            listOf(themeColor.copy(alpha = 0.2f), Color.Transparent)
                        )
                    )
                    .border(2.dp, themeColor, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(58.dp)
                        .background(Color.Black.copy(alpha = 0.5f), CircleShape)
                        .border(1.5.dp, themeColor.copy(alpha = 0.4f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)
                            .background(themeColor)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.TrackChanges,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MemoryGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)

        // Floating high-contrast info badges
        Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFFF5252).copy(alpha = 0.25f))
                    .border(1.dp, Color(0xFFFF5252), RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.5.dp)
            ) {
                Text("🔥 COMBO x5", color = Color(0xFFFFEB3B), fontSize = 8.sp, fontWeight = FontWeight.Black)
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(6.dp))
                    .background(themeColor.copy(alpha = 0.25f))
                    .border(1.dp, themeColor.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.5.dp)
            ) {
                Text("GRID: 4/9", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Black)
            }
        }

        // Connection link drawing behind cards (neon neural-link paths)
        Canvas(modifier = Modifier.fillMaxSize().padding(18.dp)) {
            val w = size.width
            val h = size.height
            // Draw a high-contrast diagonal flow line representing connection
            val path = androidx.compose.ui.graphics.Path().apply {
                moveTo(w * 0.2f, h * 0.3f)
                quadraticTo(w * 0.5f, h * 0.8f, w * 0.8f, h * 0.4f)
            }
            drawPath(
                path = path,
                color = themeColor,
                style = androidx.compose.ui.graphics.drawscope.Stroke(
                    width = 2.5.dp.toPx(),
                    pathEffect = androidx.compose.ui.graphics.PathEffect.dashPathEffect(floatArrayOf(8f, 6f))
                )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 18.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                for (row in 0 until 3) {
                    Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        for (col in 0 until 3) {
                            val isFlipped = (row == 0 && col == 1) || (row == 2 && col == 1)
                            val isMatched = (row == 1 && col == 0) || (row == 1 && col == 2)
                            
                            Box(
                                modifier = Modifier
                                    .size(26.dp)
                                    .clip(RoundedCornerShape(6.dp))
                                    .background(
                                        if (isFlipped) themeColor 
                                        else if (isMatched) themeColor.copy(alpha = 0.35f)
                                        else Color.Black.copy(alpha = 0.6f)
                                    )
                                    .border(
                                        2.dp, 
                                        if (isFlipped) Color.White else if (isMatched) themeColor else themeColor.copy(alpha = 0.3f), 
                                        RoundedCornerShape(6.dp)
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                if (isFlipped) {
                                    Icon(
                                        imageVector = Icons.Default.Psychology,
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                } else if (isMatched) {
                                    Text("★", color = themeColor, fontSize = 12.sp, fontWeight = FontWeight.Black)
                                } else {
                                    Text(
                                        text = "?",
                                        color = themeColor.copy(alpha = 0.4f),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ReasoningGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)

        // Side information elements
        Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text("STEP: 3/5", color = TextMuted, fontSize = 8.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopStart))
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFF00E5FF).copy(alpha = 0.25f))
                    .border(1.dp, Color(0xFF00E5FF), RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.5.dp)
            ) {
                Text("🧩 RATIO: 95%", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Black)
            }
        }

        Row(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 22.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left active puzzle panel
            Box(
                modifier = Modifier
                    .size(76.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .border(2.dp, themeColor, RoundedCornerShape(12.dp))
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    val sizeX = size.width / 4f
                    val sizeY = size.height / 4f
                    
                    // Main shape
                    drawRoundRect(
                        color = themeColor,
                        topLeft = androidx.compose.ui.geometry.Offset(sizeX * 1f, sizeY * 1f),
                        size = androidx.compose.ui.geometry.Size(sizeX * 2.2f, sizeY * 1.3f),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(8f)
                    )
                    drawRoundRect(
                        color = themeColor,
                        topLeft = androidx.compose.ui.geometry.Offset(sizeX * 1.5f, sizeY * 2.3f),
                        size = androidx.compose.ui.geometry.Size(sizeX * 1.2f, sizeY * 1.2f),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(8f)
                    )
                    
                    // Incoming fitting cyan block
                    drawRoundRect(
                        color = Color(0xFF00E5FF),
                        topLeft = androidx.compose.ui.geometry.Offset(sizeX * 0.1f, sizeY * 2.3f),
                        size = androidx.compose.ui.geometry.Size(sizeX * 1.3f, sizeY * 1.2f),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(8f)
                    )
                }
                
                Icon(
                    imageVector = Icons.Default.Extension,
                    contentDescription = null,
                    tint = Color.Black.copy(alpha = 0.45f),
                    modifier = Modifier.size(32.dp)
                )
            }

            // Right target match shadow/arrow representation
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color(0xFF00E5FF),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(themeColor.copy(alpha = 0.25f))
                        .border(1.dp, themeColor, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                ) {
                    Text("PERFECT!", color = Color.White, fontSize = 8.sp, fontWeight = FontWeight.Black)
                }
            }
        }
    }
}

@Composable
fun MathDuelGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)

        // Opponent VS Player indicators
        Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text("🛡️ YOU: HP 100", color = themeColor, fontSize = 8.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopStart))
            Text("⚔️ OPP: HP 80", color = Color(0xFFFF1744), fontSize = 8.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopEnd))
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 12.dp)
        ) {
            // Mini vs duel screen
            Box(
                modifier = Modifier
                    .width(170.dp)
                    .height(76.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .border(2.dp, themeColor, RoundedCornerShape(14.dp))
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left Player choices
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(themeColor)
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text("56", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Black)
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text("WINNER!", color = themeColor, fontSize = 7.sp, fontWeight = FontWeight.Black)
                    }

                    // Central active duel equation
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .clip(CircleShape)
                                .background(Color(0xFFFF1744).copy(alpha = 0.25f))
                                .border(1.dp, Color(0xFFFF1744), CircleShape)
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text("VS", color = Color(0xFFFF1744), fontSize = 8.sp, fontWeight = FontWeight.Black)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "8 × 7 = ?",
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black
                        )
                    }

                    // Right Player choices
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(CyberSurfaceVariant)
                                .border(1.dp, CyberCardBorder, RoundedCornerShape(6.dp))
                                .padding(horizontal = 8.dp, vertical = 3.dp)
                        ) {
                            Text("48", color = TextMuted, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text("SLOW", color = TextMuted, fontSize = 7.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Score Progress Bars representing the active battle tension
            Row(
                modifier = Modifier.width(140.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Player green speed progress bar
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(
                            Brush.horizontalGradient(
                                listOf(themeColor, themeColor.copy(alpha = 0.4f))
                            )
                        )
                )
                // Opponent red progress bar
                Box(
                    modifier = Modifier
                        .weight(0.7f)
                        .height(6.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(
                            Brush.horizontalGradient(
                                listOf(Color(0xFFFF1744), Color(0xFFFF1744).copy(alpha = 0.4f))
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun MentalMathGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)

        // Floating ambient operators (vibrant mathematical feel)
        Box(modifier = Modifier.fillMaxSize()) {
            Text("+", color = themeColor.copy(alpha = 0.35f), fontSize = 16.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopStart).padding(start = 14.dp, top = 10.dp))
            Text("×", color = Color(0xFFFFD54F).copy(alpha = 0.35f), fontSize = 16.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.BottomStart).padding(start = 20.dp, bottom = 14.dp))
            Text("÷", color = Color(0xFF00E5FF).copy(alpha = 0.35f), fontSize = 16.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.TopEnd).padding(end = 28.dp, top = 8.dp))
            Text("-", color = themeColor.copy(alpha = 0.35f), fontSize = 18.sp, fontWeight = FontWeight.Black, modifier = Modifier.align(Alignment.BottomEnd).padding(end = 14.dp, bottom = 10.dp))
        }

        // Side information badges
        Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFFFD54F).copy(alpha = 0.25f))
                    .border(1.dp, Color(0xFFFFD54F), RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.5.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFD54F),
                        modifier = Modifier.size(10.dp)
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Text("1,250 XP", color = Color(0xFFFFD54F), fontSize = 8.sp, fontWeight = FontWeight.Black)
                }
            }

            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .clip(RoundedCornerShape(4.dp))
                    .background(themeColor.copy(alpha = 0.2f))
                    .padding(horizontal = 5.dp, vertical = 2.dp)
            ) {
                Text("🔥 STREAK x8", color = themeColor, fontSize = 8.sp, fontWeight = FontWeight.Black)
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            // Main math card with glowing border
            Box(
                modifier = Modifier
                    .width(140.dp)
                    .height(72.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(Color.Black.copy(alpha = 0.5f))
                    .border(2.dp, themeColor, RoundedCornerShape(14.dp))
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "143 + 29 = ?",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.5.sp
                    )
                    
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(themeColor)
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("172", color = Color.Black, fontSize = 11.sp, fontWeight = FontWeight.Black)
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.Check,
                                contentDescription = null,
                                tint = Color.Black,
                                modifier = Modifier.size(12.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Time bar countdown indicator with dual gradient color
            Box(
                modifier = Modifier
                    .width(110.dp)
                    .height(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(themeColor.copy(alpha = 0.2f))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.65f) // 65% remaining time
                        .clip(RoundedCornerShape(3.dp))
                        .background(
                            Brush.horizontalGradient(
                                listOf(themeColor, Color(0xFFFFD54F))
                            )
                        )
                )
            }
        }
    }
}

@Composable
fun ArrowClickGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            val w = size.width
            val h = size.height
            val strokeWidthPx = 28f
            
            val startX = w * 0.12f
            val tipX = w * 0.88f
            val centerY = h * 0.5f
            val headSize = w * 0.28f

            // Horizontal shaft
            drawLine(
                color = Color.Black,
                start = Offset(startX, centerY),
                end = Offset(tipX, centerY),
                strokeWidth = strokeWidthPx,
                cap = StrokeCap.Round
            )

            // Upper chevron wing
            drawLine(
                color = Color.Black,
                start = Offset(tipX, centerY),
                end = Offset(tipX - headSize, centerY - headSize),
                strokeWidth = strokeWidthPx,
                cap = StrokeCap.Round
            )

            // Lower chevron wing
            drawLine(
                color = Color.Black,
                start = Offset(tipX, centerY),
                end = Offset(tipX - headSize, centerY + headSize),
                strokeWidth = strokeWidthPx,
                cap = StrokeCap.Round
            )
        }
    }
}

@Composable
fun TicTacToeGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        TechGridBackground(themeColor)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("❌", fontSize = 16.sp)
                Text("⭕", fontSize = 16.sp)
                Text("❌", fontSize = 16.sp)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("⭕", fontSize = 16.sp)
                Text("❌", fontSize = 16.sp)
                Text("⭕", fontSize = 16.sp)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("❌", fontSize = 16.sp)
                Text("⭕", fontSize = 16.sp)
                Text("❌", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun DotConnectGameMockup(themeColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val p0 = Offset(size.width * 0.2f, size.height * 0.8f)
            val p1 = Offset(size.width * 0.8f, size.height * 0.8f)
            val p2 = Offset(size.width * 0.2f, size.height * 0.45f)
            val p3 = Offset(size.width * 0.8f, size.height * 0.45f)
            val p4 = Offset(size.width * 0.5f, size.height * 0.18f)

            val edges = listOf(
                p0 to p1, p1 to p3, p3 to p2, p2 to p0,
                p2 to p4, p4 to p3, p0 to p3
            )

            for (edge in edges) {
                drawLine(
                    color = Color(0xFFE0E0E0),
                    start = edge.first,
                    end = edge.second,
                    strokeWidth = 8f,
                    cap = StrokeCap.Round
                )
            }

            val activePath = listOf(p0, p1, p3, p2, p4)
            for (i in 0 until activePath.size - 1) {
                drawLine(
                    color = Color(0xFF9C27B0),
                    start = activePath[i],
                    end = activePath[i + 1],
                    strokeWidth = 9f,
                    cap = StrokeCap.Round
                )
            }

            val points = listOf(p0, p1, p2, p3, p4)
            val dotRadius = size.width * 0.055f
            for (pt in points) {
                drawCircle(
                    color = Color(0xFF9C27B0),
                    radius = dotRadius,
                    center = pt
                )
            }
        }
    }
}

@Composable
fun GameBannerCard(
    title: String,
    score: String,
    gameBadge: String,
    benefit: String,
    icon: ImageVector,
    themeColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val difficulty = when (title.lowercase()) {
        "reaction" -> "EASY"
        "focus" -> "MEDIUM"
        "memory" -> "MEDIUM"
        "reasoning" -> "HARD"
        "math duel" -> "MEDIUM"
        "mental math" -> "HARD"
        "dot connect" -> "EASY"
        else -> "MEDIUM"
    }

    val duration = when (title.lowercase()) {
        "reaction" -> "30s"
        "focus" -> "45s"
        "memory" -> "60s"
        "reasoning" -> "90s"
        "math duel" -> "30s"
        "mental math" -> "45s"
        "dot connect" -> "60s"
        else -> "60s"
    }

    val cognitiveStat = when (title.lowercase()) {
        "reaction" -> "⚡ Speed: +25%"
        "focus" -> "🎯 Accuracy: +30%"
        "memory" -> "🧠 Recall: +20%"
        "reasoning" -> "🧩 Logic: +35%"
        "math duel" -> "⚔️ IQ Power: +40%"
        "mental math" -> "🔢 Calc Speed: +35%"
        "dot connect" -> "🔴 Path Logic: +30%"
        else -> "🧠 Focus: +15%"
    }

    val youtubeTitle = when (title.lowercase()) {
        "reaction" -> "⚡ SPEED REFLEX TEST • Can you beat 200ms?"
        "arrow click", "arrow click test", "arrow" -> "🏹 ARROW CLICK CHALLENGE • 0.1s Reflex Hit!"
        "dot connect", "dot connect puzzle", "dot", "dots" -> "🔴 ONE LINE DOT CONNECT • Connect All Dots in 1 Path!"
        "focus" -> "🎯 PRECISION AIM FOCUS • 100% Target Precision"
        "memory" -> "🧠 GRID MEMORY MATRIX • Train Spatial Recall"
        "reasoning" -> "🧩 SPATIAL LOGIC DRILL • Pattern Speed Test"
        "math duel" -> "🔢 SPEED MATH DUEL • Rapid Mental Calculation"
        "mental math" -> "➕ ARITHMETIC SPEED DRILL • Calculator Fast!"
        else -> "⚡ ULTIMATE BRAIN TRAINING CHALLENGE"
    }

    Card(
        modifier = modifier
            .width(160.dp)
            .height(235.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(1.2.dp, CyberCardBorder, RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .testTag("game_banner_card_$title"),
        colors = CardDefaults.cardColors(containerColor = CyberSurface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 1. Centered Image Mockup Box (Top position)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(82.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                CyberSurfaceVariant,
                                themeColor.copy(alpha = 0.18f)
                            )
                        )
                    )
                    .border(
                        1.dp, 
                        Brush.linearGradient(
                            colors = listOf(
                                CyberCardBorder,
                                themeColor.copy(alpha = 0.6f)
                            )
                        ), 
                        RoundedCornerShape(10.dp)
                    )
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                when (title.lowercase()) {
                    "tic tac toe", "tic tac toe strategy", "tictactoe" -> TicTacToeGameMockup(themeColor)
                    "reaction" -> ReactionGameMockup(themeColor)
                    "arrow click", "arrow click test", "arrow" -> ArrowClickGameMockup(themeColor)
                    "dot connect", "dot connect puzzle", "dot", "dots" -> DotConnectGameMockup(themeColor)
                    "focus" -> FocusGameMockup(themeColor)
                    "memory" -> MemoryGameMockup(themeColor)
                    "reasoning" -> ReasoningGameMockup(themeColor)
                    "math duel" -> MathDuelGameMockup(themeColor)
                    "mental math" -> MentalMathGameMockup(themeColor)
                    else -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            TechGridBackground(themeColor)
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(themeColor.copy(alpha = 0.15f))
                                    .border(1.2.dp, themeColor, RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = null,
                                    tint = themeColor,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    }
                }
            }

            // 2. Details Header (Title & Score)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = TextPrimary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 0.3.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = if (score == "N/A") "Upcoming" else "Best: $score",
                    color = TextSecondary,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // 3. Clean Title Subtitle without Black Strip Box
            Text(
                text = youtubeTitle,
                color = TextSecondary,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 2.dp)
            )

            // 4. Benefit Tag & Cognitive Stat Pill
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = benefit,
                    color = TextMuted,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                // Cognitive Stats Pill
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(themeColor.copy(alpha = 0.12f))
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = cognitiveStat.split(": ").lastOrNull() ?: cognitiveStat,
                        color = themeColor,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // 5. PLAY NOW Button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(themeColor)
                    .clickable { onClick() }
                    .padding(vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "PLAY NOW",
                        color = Color.Black,
                        fontSize = 9.5.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.3.sp
                    )
                    Spacer(modifier = Modifier.width(3.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryGamesInterface(
    categoryKey: String,
    onBackClick: () -> Unit,
    onPlayReactionSpeed: () -> Unit,
    onPlayArrowClick: () -> Unit,
    onPlayMemoryGame: () -> Unit,
    onPlayMathGame: () -> Unit,
    onPlayDotConnect: () -> Unit = {},
    onPlayTicTacToe: () -> Unit = {}
) {
    val categoryTitle = when (categoryKey) {
        "REACTION_FOCUS" -> "⚡ REACTION & FOCUS"
        "MEMORY_REASONING" -> "🧠 MEMORY & REASONING"
        "MATH_CALCULATION" -> "🔢 MATH & CALCULATION"
        else -> "🎮 GAMES INTERFACE"
    }

    val themeColor = when (categoryKey) {
        "REACTION_FOCUS" -> NeonYellow
        "MEMORY_REASONING" -> NeonPurpleBright
        "MATH_CALCULATION" -> Color(0xFFFF7A00)
        else -> NeonCyan
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        // Back Button & Header Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(CyberSurface)
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(10.dp))
                    .clickable { onBackClick() }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = TextPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "BACK",
                        color = TextPrimary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = categoryTitle,
                    color = TextPrimary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    letterSpacing = 0.5.sp
                )
                Text(
                    text = "Scroll down to browse games in this category",
                    color = TextSecondary,
                    fontSize = 11.sp
                )
            }
        }

        // 2-Column Grid Layout (2 Games per row) for ONLY games in this category
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            when (categoryKey) {
                "REACTION_FOCUS" -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CategoryGameCardItem(
                            title = "Speed Reflex Test",
                            badge = "⚡ SPEED TAP",
                            benefit = "Fast Reaction",
                            description = "Measure raw reaction speed! Tap as soon as screen turns GREEN.",
                            score = "180 ms",
                            icon = Icons.Default.FlashOn,
                            themeColor = NeonYellow,
                            previewGraphicTitle = "reaction",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayReactionSpeed
                        )
                        CategoryGameCardItem(
                            title = "Red Dot Target",
                            badge = "🔴 RED DOT TARGET",
                            benefit = "Target Reflex",
                            description = "Infinite mode! Tap glowing red dots with ocean wave ripples instantly.",
                            score = "165 ms",
                            icon = Icons.Default.TrackChanges,
                            themeColor = Color(0xFFFF1744),
                            previewGraphicTitle = "red dot target",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayReactionSpeed
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CategoryGameCardItem(
                            title = "Arrow Click Test",
                            badge = "🏹 ARROW CLICK",
                            benefit = "Precision Aiming",
                            description = "Curved arrow points randomly. Tap the target tip extending from arrow!",
                            score = "220 ms",
                            icon = Icons.Default.Navigation,
                            themeColor = Color(0xFFFFD700),
                            previewGraphicTitle = "arrow click",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayArrowClick
                        )
                        CategoryGameCardItem(
                            title = "Aim Focus Target",
                            badge = "🎯 AIM TARGET",
                            benefit = "Visual Tracking",
                            description = "Train visual precision and sustained focus under time limits.",
                            score = "604 pts",
                            icon = Icons.Default.TrackChanges,
                            themeColor = NeonCyan,
                            previewGraphicTitle = "focus",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayReactionSpeed
                        )
                    }
                }
                "MEMORY_REASONING" -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CategoryGameCardItem(
                            title = "Tic Tac Toe",
                            badge = "⭕❌ TIC TAC TOE",
                            benefit = "Tactical Play",
                            description = "Strategic 3x3 grid battle! Outsmart AI Bot or friend in 2-Player mode.",
                            score = "10 Wins",
                            icon = Icons.Default.Close,
                            themeColor = NeonCyan,
                            previewGraphicTitle = "tic tac toe",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayTicTacToe
                        )
                        CategoryGameCardItem(
                            title = "Dot Connect",
                            badge = "🔴 ONE LINE CONNECT",
                            benefit = "Path Logic",
                            description = "Connect all dots on grid in single unbroken line path!",
                            score = "Level 5",
                            icon = Icons.Default.Grain,
                            themeColor = NeonYellow,
                            previewGraphicTitle = "dot connect",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayDotConnect
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CategoryGameCardItem(
                            title = "Grid Memory",
                            badge = "🧠 GRID MATCH",
                            benefit = "Spatial Memory",
                            description = "Memorize highlighted tiles on grid before they flip.",
                            score = "Level 8",
                            icon = Icons.Default.Psychology,
                            themeColor = NeonPurpleBright,
                            previewGraphicTitle = "memory",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayMemoryGame
                        )
                        CategoryGameCardItem(
                            title = "Logic Shapes",
                            badge = "🧩 LOGIC SHAPES",
                            benefit = "Pattern Reasoning",
                            description = "Analyze sequence pattern rules and deduce missing shapes.",
                            score = "721 pts",
                            icon = Icons.Default.Extension,
                            themeColor = NeonBlue,
                            previewGraphicTitle = "reasoning",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayMemoryGame
                        )
                    }
                }
                "MATH_CALCULATION" -> {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CategoryGameCardItem(
                            title = "Speed Math Duel",
                            badge = "🔢 SPEED CALC",
                            benefit = "Mental Calc",
                            description = "Solve arithmetic equations against shrinking timer.",
                            score = "890 pts",
                            icon = Icons.Default.MilitaryTech,
                            themeColor = Color(0xFFFF7A00),
                            previewGraphicTitle = "math duel",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayMathGame
                        )
                        CategoryGameCardItem(
                            title = "Arithmetic Drill",
                            badge = "➕ ARITHMETIC DRILL",
                            benefit = "Fact Recall",
                            description = "Practice rapid addition, subtraction, multiplication & division.",
                            score = "120 pts",
                            icon = Icons.Default.Star,
                            themeColor = NeonGreen,
                            previewGraphicTitle = "mental math",
                            modifier = Modifier.weight(1f),
                            onPlayClick = onPlayMathGame
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "👇 ALL GAMES FOR THIS CATEGORY SHOWN ABOVE 👇",
                    color = TextMuted,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun CategoryGameCardItem(
    title: String,
    badge: String,
    benefit: String,
    description: String,
    score: String,
    icon: ImageVector,
    themeColor: Color,
    previewGraphicTitle: String,
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit
) {
    val youtubeTitle = when (title.lowercase()) {
        "speed reflex test", "reaction" -> "⚡ SPEED REFLEX TEST • Beat 200ms!"
        "red dot target", "red dot reflex", "red dot", "dot target" -> "🔴 RED DOT TARGET • Ocean Ripple Hits!"
        "arrow click test", "arrow click", "arrow" -> "🏹 ARROW CLICK • 0.1s Reflex Hit!"
        "dot connect puzzle", "dot connect", "dot", "dots" -> "🔴 ONE LINE CONNECT • Path Clear!"
        "tic tac toe strategy", "tic tac toe", "tictactoe" -> "⭕❌ TIC TAC TOE • AI & 2-Player"
        "aim focus target", "focus" -> "🎯 AIM FOCUS • 100% Target Aim"
        "grid memory match", "grid memory", "memory" -> "🧠 GRID MEMORY • Recall Matrix"
        "logic shapes drill", "logic shapes", "reasoning" -> "🧩 SPATIAL LOGIC • Pattern Speed"
        "speed math duel", "math duel" -> "🔢 SPEED MATH • Rapid Mental Calc"
        "arithmetic drill", "mental math" -> "➕ ARITHMETIC DRILL • Quick Facts"
        else -> "⚡ ULTIMATE BRAIN CHALLENGE"
    }

    Card(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, themeColor.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
            .testTag("category_game_poster_$title"),
        colors = CardDefaults.cardColors(containerColor = CyberSurface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Graphic Box Preview (Top Position Thumbnail Banner)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(105.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                CyberSurfaceVariant,
                                Color.Black
                            )
                        )
                    )
                    .border(
                        1.dp,
                        Brush.linearGradient(
                            colors = listOf(
                                CyberCardBorder,
                                themeColor.copy(alpha = 0.5f)
                            )
                        ),
                        RoundedCornerShape(10.dp)
                    )
                    .padding(2.dp),
                contentAlignment = Alignment.Center
            ) {
                GamePreviewGraphic(
                    title = previewGraphicTitle,
                    themeColor = themeColor,
                    icon = icon
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Game Title & Best Score Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = TextPrimary,
                    fontSize = 12.5.sp,
                    fontWeight = FontWeight.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Best: $score",
                    color = TextSecondary,
                    fontSize = 9.5.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Clean Subtitle Text without Black Strip Box
            Text(
                text = youtubeTitle,
                color = TextSecondary,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 2.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Benefit Tag
            Text(
                text = "🎯 Skill: $benefit",
                color = themeColor,
                fontSize = 9.5.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Game Description
            Text(
                text = description,
                color = TextSecondary,
                fontSize = 9.5.sp,
                textAlign = TextAlign.Center,
                lineHeight = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.height(28.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Action Button "PLAY GAME"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(34.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(themeColor)
                    .clickable { onPlayClick() },
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color.Black,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "PLAY GAME",
                        color = Color.Black,
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }
    }
}

@Composable
fun TrainYourBrainSection(
    horizontalPadding: androidx.compose.ui.unit.Dp = 16.dp,
    onClick: () -> Unit,
    onMathClick: () -> Unit = {},
    onMemoryClick: () -> Unit = {},
    onReactionClick: () -> Unit = {},
    onDotConnectClick: () -> Unit = {},
    onTicTacToeClick: () -> Unit = {},
    onCategoryClick: (String) -> Unit = {}
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "GAME CATEGORIES",
                color = TextPrimary,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.5.sp
            )

            Text(
                text = if (isExpanded) "See Less <" else "See All >",
                color = NeonCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { isExpanded = !isExpanded }
                    .padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        if (isExpanded) {
            // 2-column Grid Layout (2 per row stacked vertically)
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = horizontalPadding)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CategoryCard(
                        title = "Reaction",
                        score = "512",
                        gameBadge = "⚡ SPEED TAP",
                        benefit = "Fast Reflexes",
                        icon = Icons.Default.FlashOn,
                        themeColor = NeonYellow,
                        modifier = Modifier.weight(1f),
                        onClick = { onCategoryClick("REACTION_FOCUS") }
                    )
                    CategoryCard(
                        title = "Memory",
                        score = "680",
                        gameBadge = "🧠 GRID MATCH",
                        benefit = "Boost Memory",
                        icon = Icons.Default.Psychology,
                        themeColor = NeonPurpleBright,
                        modifier = Modifier.weight(1f),
                        onClick = { onCategoryClick("MEMORY_REASONING") }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CategoryCard(
                        title = "Focus",
                        score = "604",
                        gameBadge = "🎯 AIM TARGET",
                        benefit = "Sharp Focus",
                        icon = Icons.Default.TrackChanges,
                        themeColor = NeonCyan,
                        modifier = Modifier.weight(1f),
                        onClick = { onCategoryClick("REACTION_FOCUS") }
                    )
                    CategoryCard(
                        title = "Reasoning",
                        score = "721",
                        gameBadge = "🧩 LOGIC SHAPES",
                        benefit = "Logic Skills",
                        icon = Icons.Default.Extension,
                        themeColor = NeonBlue,
                        modifier = Modifier.weight(1f),
                        onClick = { onCategoryClick("MEMORY_REASONING") }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    CategoryCard(
                        title = "Math Duel",
                        score = "890",
                        gameBadge = "🔢 SPEED CALC",
                        benefit = "Quick Calc",
                        icon = Icons.Default.MilitaryTech,
                        themeColor = Color(0xFFFF7A00),
                        modifier = Modifier.weight(1f),
                        onClick = { onCategoryClick("MATH_CALCULATION") }
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        } else {
            // Horizontal Swipeable Row with Snapping for CATEGORIES ONLY
            val listState = rememberLazyListState()
            val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState = listState)

            LazyRow(
                state = listState,
                flingBehavior = snapFlingBehavior,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(horizontal = horizontalPadding)
            ) {
                item {
                    CategoryCard(
                        title = "Reaction",
                        score = "512",
                        gameBadge = "⚡ SPEED TAP",
                        benefit = "Fast Reflexes",
                        icon = Icons.Default.FlashOn,
                        themeColor = NeonYellow,
                        modifier = Modifier.width(135.dp),
                        onClick = { onCategoryClick("REACTION_FOCUS") }
                    )
                }
                item {
                    CategoryCard(
                        title = "Memory",
                        score = "680",
                        gameBadge = "🧠 GRID MATCH",
                        benefit = "Boost Memory",
                        icon = Icons.Default.Psychology,
                        themeColor = NeonPurpleBright,
                        modifier = Modifier.width(135.dp),
                        onClick = { onCategoryClick("MEMORY_REASONING") }
                    )
                }
                item {
                    CategoryCard(
                        title = "Focus",
                        score = "604",
                        gameBadge = "🎯 AIM TARGET",
                        benefit = "Sharp Focus",
                        icon = Icons.Default.TrackChanges,
                        themeColor = NeonCyan,
                        modifier = Modifier.width(135.dp),
                        onClick = { onCategoryClick("REACTION_FOCUS") }
                    )
                }
                item {
                    CategoryCard(
                        title = "Reasoning",
                        score = "721",
                        gameBadge = "🧩 LOGIC SHAPES",
                        benefit = "Logic Skills",
                        icon = Icons.Default.Extension,
                        themeColor = NeonBlue,
                        modifier = Modifier.width(135.dp),
                        onClick = { onCategoryClick("MEMORY_REASONING") }
                    )
                }
                item {
                    CategoryCard(
                        title = "Math Duel",
                        score = "890",
                        gameBadge = "🔢 SPEED CALC",
                        benefit = "Quick Calc",
                        icon = Icons.Default.MilitaryTech,
                        themeColor = Color(0xFFFF7A00),
                        modifier = Modifier.width(135.dp),
                        onClick = { onCategoryClick("MATH_CALCULATION") }
                    )
                }
            }
        }
    }
}

@Composable
fun GamesInterfaceSection(
    horizontalPadding: androidx.compose.ui.unit.Dp = 16.dp,
    onClick: () -> Unit,
    onMathClick: () -> Unit = {},
    onMemoryClick: () -> Unit = {},
    onReactionClick: () -> Unit = {},
    onArrowClick: () -> Unit = {},
    onDotConnectClick: () -> Unit = {},
    onTicTacToeClick: () -> Unit = {},
    onCategoryClick: (String) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        // --- CATEGORY 1: REACTION & FOCUS ---
        Text(
            text = "REACTION & FOCUS",
            color = TextPrimary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.5.sp,
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = 8.dp)
        )

        val listState1 = rememberLazyListState()
        val snapFlingBehavior1 = rememberSnapFlingBehavior(lazyListState = listState1)

        LazyRow(
            state = listState1,
            flingBehavior = snapFlingBehavior1,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = horizontalPadding)
        ) {
            item {
                GameBannerCard(
                    title = "Reaction",
                    score = "512",
                    gameBadge = "⚡ SPEED TAP",
                    benefit = "Fast Reflexes",
                    icon = Icons.Default.FlashOn,
                    themeColor = NeonYellow,
                    onClick = onReactionClick
                )
            }
            item {
                GameBannerCard(
                    title = "Red Dot",
                    score = "165",
                    gameBadge = "🔴 RED DOT TARGET",
                    benefit = "Ocean Wave Hits",
                    icon = Icons.Default.TrackChanges,
                    themeColor = Color(0xFFFF1744),
                    onClick = onReactionClick
                )
            }
            item {
                GameBannerCard(
                    title = "Arrow Click",
                    score = "220",
                    gameBadge = "🏹 ARROW CLICK",
                    benefit = "Tap Arrow Tip",
                    icon = Icons.Default.Navigation,
                    themeColor = Color(0xFFFFD700),
                    onClick = onArrowClick
                )
            }
            item {
                GameBannerCard(
                    title = "Focus",
                    score = "604",
                    gameBadge = "🎯 AIM TARGET",
                    benefit = "Sharp Focus",
                    icon = Icons.Default.TrackChanges,
                    themeColor = NeonCyan,
                    onClick = onReactionClick
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- CATEGORY 2: MEMORY & REASONING ---
        Text(
            text = "MEMORY & REASONING",
            color = TextPrimary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.5.sp,
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = 8.dp)
        )

        val listState2 = rememberLazyListState()
        val snapFlingBehavior2 = rememberSnapFlingBehavior(lazyListState = listState2)

        LazyRow(
            state = listState2,
            flingBehavior = snapFlingBehavior2,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = horizontalPadding)
        ) {
            item {
                GameBannerCard(
                    title = "Tic Tac Toe",
                    score = "10 Wins",
                    gameBadge = "⭕❌ TIC TAC TOE",
                    benefit = "Tactical Strategy",
                    icon = Icons.Default.Close,
                    themeColor = NeonCyan,
                    onClick = onTicTacToeClick
                )
            }
            item {
                GameBannerCard(
                    title = "Dot Connect",
                    score = "Lvl 5",
                    gameBadge = "🔴 ONE LINE CONNECT",
                    benefit = "Connect All Dots",
                    icon = Icons.Default.Grain,
                    themeColor = NeonYellow,
                    onClick = onDotConnectClick
                )
            }
            item {
                GameBannerCard(
                    title = "Memory",
                    score = "680",
                    gameBadge = "🧠 GRID MATCH",
                    benefit = "Boost Memory",
                    icon = Icons.Default.Psychology,
                    themeColor = NeonPurpleBright,
                    onClick = onMemoryClick
                )
            }
            item {
                GameBannerCard(
                    title = "Reasoning",
                    score = "721",
                    gameBadge = "🧩 LOGIC SHAPES",
                    benefit = "Logic Skills",
                    icon = Icons.Default.Extension,
                    themeColor = NeonBlue,
                    onClick = onMemoryClick
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- CATEGORY 3: MATH & CALCULATION ---
        Text(
            text = "MATH & CALCULATION",
            color = TextPrimary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.5.sp,
            modifier = Modifier.padding(horizontal = horizontalPadding, vertical = 8.dp)
        )

        val listState3 = rememberLazyListState()
        val snapFlingBehavior3 = rememberSnapFlingBehavior(lazyListState = listState3)

        LazyRow(
            state = listState3,
            flingBehavior = snapFlingBehavior3,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = horizontalPadding)
        ) {
            item {
                GameBannerCard(
                    title = "Math Duel",
                    score = "890",
                    gameBadge = "🔢 SPEED CALC",
                    benefit = "Quick Calc",
                    icon = Icons.Default.MilitaryTech,
                    themeColor = Color(0xFFFF7A00),
                    onClick = onMathClick
                )
            }
            item {
                GameBannerCard(
                    title = "Mental Math",
                    score = "N/A",
                    gameBadge = "➕ ARITHMETIC DRILL",
                    benefit = "Rapid Arithmetic",
                    icon = Icons.Default.Star,
                    themeColor = NeonGreen,
                    onClick = onMathClick
                )
            }
        }
    }
}

@Composable
fun GamePreviewGraphic(
    title: String,
    themeColor: Color,
    icon: ImageVector
) {
    val isArrow = title.lowercase().contains("arrow")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(if (isArrow) Color.White else themeColor.copy(alpha = 0.28f))
            .border(1.2.dp, if (isArrow) Color(0xFFDDDDDD) else themeColor.copy(alpha = 0.4f), RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        when (title.lowercase()) {
            "arrow click", "arrow click test", "arrow" -> {
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    val w = size.width
                    val h = size.height
                    val strokeWidthPx = 14f
                    
                    val startX = w * 0.12f
                    val tipX = w * 0.88f
                    val centerY = h * 0.5f
                    val headSize = h * 0.4f

                    // Horizontal shaft
                    drawLine(
                        color = Color.Black,
                        start = Offset(startX, centerY),
                        end = Offset(tipX, centerY),
                        strokeWidth = strokeWidthPx,
                        cap = StrokeCap.Round
                    )

                    // Upper chevron wing
                    drawLine(
                        color = Color.Black,
                        start = Offset(tipX, centerY),
                        end = Offset(tipX - headSize, centerY - headSize),
                        strokeWidth = strokeWidthPx,
                        cap = StrokeCap.Round
                    )

                    // Lower chevron wing
                    drawLine(
                        color = Color.Black,
                        start = Offset(tipX, centerY),
                        end = Offset(tipX - headSize, centerY + headSize),
                        strokeWidth = strokeWidthPx,
                        cap = StrokeCap.Round
                    )
                }
            }
            "reaction" -> {
                // Reaction preview: Glowing Target & Lightning Flash
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(themeColor.copy(alpha = 0.2f))
                            .border(1.2.dp, themeColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.FlashOn,
                            contentDescription = null,
                            tint = themeColor,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "⚡ TAP!",
                        color = themeColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
            "red dot target", "red dot", "dot target", "burst target" -> {
                // Realistic Red Dot Target thumbnail graphic with ocean wave ripples and target crosshair
                Canvas(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                ) {
                    val cx = size.width / 2f
                    val cy = size.height / 2f

                    // Crosshair target grid lines
                    drawLine(
                        color = Color(0xFF334155),
                        start = Offset(cx - 32.dp.toPx(), cy),
                        end = Offset(cx + 32.dp.toPx(), cy),
                        strokeWidth = 1.dp.toPx()
                    )
                    drawLine(
                        color = Color(0xFF334155),
                        start = Offset(cx, cy - 20.dp.toPx()),
                        end = Offset(cx, cy + 20.dp.toPx()),
                        strokeWidth = 1.dp.toPx()
                    )

                    // Concentric ocean water ripple rings
                    drawCircle(
                        color = Color(0xFFFF2A2A).copy(alpha = 0.25f),
                        radius = 22.dp.toPx(),
                        center = Offset(cx, cy),
                        style = Stroke(width = 1.5.dp.toPx())
                    )
                    drawCircle(
                        color = Color(0xFFFF2A2A).copy(alpha = 0.55f),
                        radius = 15.dp.toPx(),
                        center = Offset(cx, cy),
                        style = Stroke(width = 2.dp.toPx())
                    )

                    // Soft Red Glowing Outer Aura
                    drawCircle(
                        color = Color(0xFFFF1744).copy(alpha = 0.35f),
                        radius = 11.dp.toPx(),
                        center = Offset(cx, cy)
                    )

                    // Core Solid Red Center Dot Target
                    drawCircle(
                        color = Color(0xFFFF1744),
                        radius = 7.dp.toPx(),
                        center = Offset(cx, cy)
                    )
                    drawCircle(
                        color = Color.White,
                        radius = 2.5.dp.toPx(),
                        center = Offset(cx, cy)
                    )
                }
            }
            "memory" -> {
                // Memory preview: Mini 3x3 Card Grid Graphic
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(3) { index ->
                        Box(
                            modifier = Modifier
                                .size(width = 20.dp, height = 26.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(
                                    if (index == 1) themeColor.copy(alpha = 0.85f)
                                    else themeColor.copy(alpha = 0.2f)
                                )
                                .border(
                                    1.2.dp,
                                    if (index == 1) themeColor else themeColor.copy(alpha = 0.4f),
                                    RoundedCornerShape(4.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (index == 1) "🧠" else "?",
                                fontSize = 10.sp,
                                color = if (index == 1) Color.Black else TextMuted
                            )
                        }
                    }
                }
            }
            "focus" -> {
                // Focus preview: Concentric Target Crosshair
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .clip(CircleShape)
                        .background(themeColor.copy(alpha = 0.15f))
                        .border(1.2.dp, themeColor, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .border(1.2.dp, themeColor.copy(alpha = 0.7f), CircleShape)
                    )
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(themeColor)
                    )
                }
            }
            "reasoning" -> {
                // Reasoning preview: Overlapping Puzzle Logic Shapes
                Row(
                    horizontalArrangement = Arrangement.spacedBy((-2).dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(themeColor.copy(alpha = 0.8f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🧩", fontSize = 10.sp)
                    }
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(NeonCyan.copy(alpha = 0.8f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("★", fontSize = 9.sp, color = Color.Black)
                    }
                }
            }
            else -> {
                // Math Duel or Default preview: Formula Card "7×8=?"
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(themeColor.copy(alpha = 0.25f))
                        .border(1.2.dp, themeColor.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🔢 7 × 8 = ?",
                        color = themeColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    title: String,
    score: String,
    gameBadge: String,
    benefit: String,
    icon: ImageVector,
    themeColor: Color,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, CyberCardBorder, RoundedCornerShape(14.dp))
            .clickable { onClick() }
            .testTag("category_card_$title"),
        colors = CardDefaults.cardColors(containerColor = CyberSurface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Game Example Preview Graphic Image Box
            GamePreviewGraphic(
                title = title,
                themeColor = themeColor,
                icon = icon
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = title,
                color = TextPrimary,
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = gameBadge,
                color = themeColor,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.3.sp
            )

            Text(
                text = benefit,
                color = TextMuted,
                fontSize = 9.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 1
            )

            Text(
                text = "Score: $score",
                color = TextSecondary,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Vibrant Filled PLAY Button matching reference screenshot
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(themeColor)
                    .clickable { onClick() }
                    .padding(vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "PLAY",
                        color = Color.Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.5.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Play Game",
                        tint = Color.Black,
                        modifier = Modifier.size(12.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavBar(
    selectedTab: String = "HOME",
    onTabClick: (String) -> Unit
) {
    val navItems = listOf(
        NavItem("HOME", Icons.Default.Home, selectedTab == "HOME"),
        NavItem("GAMES", Icons.Outlined.SportsEsports, selectedTab == "GAMES"),
        NavItem("BATTLE", Icons.Default.MilitaryTech, selectedTab == "BATTLE"),
        NavItem("PROGRESS", Icons.Outlined.Leaderboard, selectedTab == "PROGRESS"),
        NavItem("PROFILE", Icons.Outlined.Person, selectedTab == "PROFILE")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CyberSurface)
            .windowInsetsPadding(WindowInsets.navigationBars)
    ) {
        // Top divider line for navigation bar border
        HorizontalDivider(
            thickness = 1.dp,
            color = CyberCardBorder
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navItems.forEach { item ->
                val isSelected = item.isSelected

                // Clean flat design matching Sero style navigation items
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onTabClick(item.label) }
                        .padding(vertical = 4.dp)
                        .testTag("nav_${item.label.lowercase()}"),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label,
                            tint = if (isSelected) NeonGreen else TextSecondary,
                            modifier = Modifier.size(22.dp)
                        )

                        Spacer(modifier = Modifier.height(3.dp))

                        Text(
                            text = item.label,
                            color = if (isSelected) NeonGreen else TextSecondary,
                            fontSize = 10.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            maxLines = 1
                        )
                    }
                }
            }
        }
    }
}

data class NavItem(
    val label: String,
    val icon: ImageVector,
    val isSelected: Boolean
)

@Composable
fun GameSettingsDialog(onDismiss: () -> Unit) {
    val context = LocalContext.current
    var soundEnabled by remember { mutableStateOf(true) }
    var bgmEnabled by remember { mutableStateOf(RelaxingBgmPlayer.isBgmEnabled) }
    var volumeLevel by remember { mutableStateOf(RelaxingBgmPlayer.volume) }
    var vibrationEnabled by remember { mutableStateOf(true) }
    var difficulty by remember { mutableStateOf("Medium") }
    var notificationsEnabled by remember { mutableStateOf(true) }
    var hfrMode by remember { mutableStateOf(true) }
    var playerName by remember { mutableStateOf("Elite Mind") }
    var isEditingName by remember { mutableStateOf(false) }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(0.92f)
                    .fillMaxHeight(0.85f)
                    .padding(vertical = 12.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .border(1.5.dp, NeonCyan.copy(alpha = 0.5f), RoundedCornerShape(24.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberSurface)
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                // Header with Title & Close Icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(NeonCyan.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                                tint = NeonCyan,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "GAME SETTINGS",
                            color = TextPrimary,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }

                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(CyberSurfaceVariant)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = TextSecondary,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                HorizontalDivider(color = CyberCardBorder, thickness = 1.dp)

                // 👤 PLAYER PROFILE SECTION
                Text(
                    text = "PLAYER PROFILE",
                    color = NeonGold,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(CyberSurfaceVariant)
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(NeonPurple.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "User",
                                tint = NeonPurpleBright,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        if (isEditingName) {
                            OutlinedTextField(
                                value = playerName,
                                onValueChange = { playerName = it },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(0.85f),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = NeonCyan,
                                    unfocusedBorderColor = CyberCardBorder,
                                    focusedTextColor = TextPrimary,
                                    unfocusedTextColor = TextPrimary
                                )
                            )
                        } else {
                            Column {
                                Text(
                                    text = playerName,
                                    color = TextPrimary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Rank: Beginner • Lv. 0",
                                    color = TextMuted,
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }

                    IconButton(onClick = {
                        isEditingName = !isEditingName
                        if (!isEditingName) {
                            Toast.makeText(context, "Name updated!", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                        Icon(
                            imageVector = if (isEditingName) Icons.Default.Check else Icons.Default.Edit,
                            contentDescription = "Edit Name",
                            tint = NeonCyan,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }

                // 🔊 AUDIO & SOUND SECTION
                Text(
                    text = "AUDIO & SOUNDS",
                    color = NeonCyan,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                // SFX Switch
                SettingSwitchRow(
                    title = "Game Sound FX",
                    subtitle = "Sound effects during gameplay",
                    icon = if (soundEnabled) Icons.Default.VolumeUp else Icons.Default.VolumeOff,
                    iconTint = NeonYellow,
                    checked = soundEnabled,
                    onCheckedChange = { soundEnabled = it }
                )

                // BGM Switch
                SettingSwitchRow(
                    title = "Relaxing Game BGM",
                    subtitle = "Artist-crafted soothing background music during gameplay",
                    icon = Icons.Default.VolumeUp,
                    iconTint = NeonPurpleBright,
                    checked = bgmEnabled,
                    onCheckedChange = {
                        bgmEnabled = it
                        RelaxingBgmPlayer.setEnabled(it)
                    }
                )

                // Volume Slider
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(CyberSurfaceVariant)
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Master Volume",
                            color = TextPrimary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "${(volumeLevel * 100).toInt()}%",
                            color = NeonCyan,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Slider(
                        value = volumeLevel,
                        onValueChange = {
                            volumeLevel = it
                            RelaxingBgmPlayer.volume = it
                        },
                        colors = SliderDefaults.colors(
                            thumbColor = NeonCyan,
                            activeTrackColor = NeonCyan,
                            inactiveTrackColor = CyberCardBorder
                        )
                    )
                }

                // 🎮 GAMEPLAY PREFERENCES
                Text(
                    text = "GAMEPLAY & GRAPHICS",
                    color = NeonBlue,
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                )

                // Difficulty Selector
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(CyberSurfaceVariant)
                        .padding(12.dp)
                ) {
                    Text(
                        text = "Game Difficulty",
                        color = TextPrimary,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf("Easy", "Medium", "Hard").forEach { diff ->
                            val isSelected = difficulty == diff
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(
                                        if (isSelected) NeonCyan.copy(alpha = 0.25f)
                                        else CyberSurface
                                    )
                                    .border(
                                        1.dp,
                                        if (isSelected) NeonCyan else CyberCardBorder,
                                        RoundedCornerShape(8.dp)
                                    )
                                    .clickable { difficulty = diff }
                                    .padding(vertical = 8.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = diff,
                                    color = if (isSelected) NeonCyan else TextSecondary,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                )
                            }
                        }
                    }
                }

                // High Refresh Rate Mode Switch
                SettingSwitchRow(
                    title = "60/90 FPS Ultra Smooth",
                    subtitle = "Boost responsiveness for tap games",
                    icon = Icons.Default.FlashOn,
                    iconTint = NeonYellow,
                    checked = hfrMode,
                    onCheckedChange = { hfrMode = it }
                )

                // Daily Reminder Switch
                SettingSwitchRow(
                    title = "Daily Brain Workout Reminder",
                    subtitle = "Get notified to train everyday",
                    icon = Icons.Default.Notifications,
                    iconTint = NeonPurpleBright,
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )

                HorizontalDivider(color = CyberCardBorder, thickness = 1.dp)

                // Actions: Reset Progress & Save Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFF2A1518))
                            .border(1.dp, Color(0xFFFF4444).copy(alpha = 0.4f), RoundedCornerShape(12.dp))
                            .clickable {
                                Toast.makeText(context, "Progress Reset to Lv 0!", Toast.LENGTH_SHORT).show()
                            }
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Reset",
                                tint = Color(0xFFFF5555),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "RESET",
                                color = Color(0xFFFF5555),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(2f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                Brush.horizontalGradient(
                                    listOf(NeonCyan, NeonPurpleBright)
                                )
                            )
                            .clickable {
                                Toast.makeText(context, "Settings saved!", Toast.LENGTH_SHORT).show()
                                onDismiss()
                            }
                            .padding(vertical = 12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "SAVE & CLOSE",
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }
                }
            }
        }
    }
}
}

@Composable
fun SettingSwitchRow(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconTint: Color,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(CyberSurfaceVariant)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(iconTint.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    tint = iconTint,
                    modifier = Modifier.size(16.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = title,
                    color = TextPrimary,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = subtitle,
                    color = TextMuted,
                    fontSize = 10.sp
                )
            }
        }

        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Black,
                checkedTrackColor = NeonCyan,
                uncheckedThumbColor = TextMuted,
                uncheckedTrackColor = CyberSurface
            ),
            modifier = Modifier.scale(0.85f)
        )
    }
}

data class MathQuestion(
    val questionText: String,
    val correctAnswer: Int,
    val options: List<Int>
)

data class GameHistoryRecord(
    val id: String = java.util.UUID.randomUUID().toString(),
    val gameName: String,
    val score: Int,
    val stars: Int,
    val titleTag: String,
    val accuracyText: String,
    val highestStreak: Int,
    val timestamp: String
)

fun calculateGameRating(score: Int): Pair<Int, String> {
    return when {
        score >= 150 -> Pair(5, "GRANDMASTER")
        score >= 100 -> Pair(5, "MASTER")
        score >= 70  -> Pair(4, "EXPERT")
        score >= 40  -> Pair(3, "AVERAGE")
        score >= 20  -> Pair(2, "ROOKIE")
        else -> Pair(1, "BEGINNER")
    }
}

fun getTitleTagColor(titleTag: String): Color {
    return when (titleTag) {
        "GRANDMASTER" -> NeonGold
        "MASTER" -> Color(0xFFFFD700)
        "EXPERT" -> NeonPurpleBright
        "AVERAGE" -> NeonCyan
        "ROOKIE" -> NeonGreen
        else -> Color(0xFFFF7A00)
    }
}

fun getGameIcon(gameName: String): String {
    return when {
        gameName.contains("Math") -> "🔢"
        gameName.contains("Reaction") || gameName.contains("Reflex") -> "⚡"
        gameName.contains("Memory") -> "🧠"
        gameName.contains("Pattern") -> "🧩"
        else -> "🎮"
    }
}

@Composable
fun ProgressTabScreen(
    gameHistory: List<GameHistoryRecord>,
    onPlayMathGame: () -> Unit
) {
    // Selected record state for dynamic top banner display
    var selectedRecordId by remember { mutableStateOf<String?>(null) }

    // Fallback to latest game or first item if none selected
    val activeRecord = gameHistory.find { it.id == selectedRecordId } ?: gameHistory.firstOrNull()

    // Title Tag & Rating Color
    val activeTitle = activeRecord?.titleTag ?: "BEGINNER"
    val activeTagColor = getTitleTagColor(activeTitle)

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Dynamic Mind Performance Banner Card (Updates when clicking history cards!)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .border(
                    width = 1.5.dp,
                    brush = Brush.linearGradient(
                        listOf(activeTagColor, NeonCyan, NeonPurpleBright)
                    ),
                    shape = RoundedCornerShape(20.dp)
                )
                .testTag("progress_top_banner"),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Header Row with Strict Weight to Prevent Overlap
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left Column (Game / Banner Name) with weight(1f) to avoid overlapping right badge
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(activeTagColor.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(getGameIcon(activeRecord?.gameName ?: ""), fontSize = 18.sp)
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = activeRecord?.gameName ?: "MIND PERFORMANCE",
                                color = TextPrimary,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 0.3.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = if (activeRecord != null) "🕒 ${activeRecord.timestamp} (Selected Match)" else "Your Overall Progress",
                                color = TextSecondary,
                                fontSize = 10.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Title Badge Pill on Right Corner (No Overlap Fix!)
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(activeTagColor.copy(alpha = 0.2f))
                            .border(1.dp, activeTagColor, RoundedCornerShape(20.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "👑 $activeTitle",
                            color = activeTagColor,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black,
                            maxLines = 1
                        )
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Stats Grid Row (4 Pills reflecting active match)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Score
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CyberSurfaceVariant)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Score", color = TextMuted, fontSize = 9.sp)
                            Text("${activeRecord?.score ?: 0}", color = NeonGold, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    // Stars
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CyberSurfaceVariant)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Stars", color = TextMuted, fontSize = 9.sp)
                            Text("⭐ ${activeRecord?.stars ?: 5}/5", color = Color(0xFFFFD700), fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    // Accuracy / Result
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CyberSurfaceVariant)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Accuracy", color = TextMuted, fontSize = 9.sp)
                            Text(
                                text = activeRecord?.accuracyText?.take(6) ?: "100%",
                                color = NeonCyan,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    // Max Streak
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(CyberSurfaceVariant)
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Streak", color = TextMuted, fontSize = 9.sp)
                            Text("🔥 ${activeRecord?.highestStreak ?: 0}", color = Color(0xFFFF7A00), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // XP Fill Progress Bar for Active Match
                val displayScore = activeRecord?.score ?: 0
                val currentLevel = (displayScore / 30) + 1
                val xpProgress = ((displayScore % 150) / 150f).coerceIn(0.1f, 1f)
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("LEVEL $currentLevel • $activeTitle", color = NeonGreen, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        Text("$displayScore / 150 XP", color = TextMuted, fontSize = 11.sp)
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    LinearProgressIndicator(
                        progress = { xpProgress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = NeonGreen,
                        trackColor = CyberSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Tap Hint Banner
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(CyberSurfaceVariant.copy(alpha = 0.6f))
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "💡 Click on any game below to view its live statistics!",
                        color = TextSecondary,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Play Math Challenge Action Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Brush.horizontalGradient(
                                listOf(Color(0xFFFF7A00), NeonYellow)
                            )
                        )
                        .clickable { onPlayMathGame() }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚡", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "PLAY NEW GAME",
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }
        }

        // 2. Section Title
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "SAVED GAME HISTORY",
                color = TextPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Black,
                letterSpacing = 0.5.sp
            )

            Text(
                text = "${gameHistory.size} Matches Saved",
                color = NeonCyan,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // 3. Saved History Banner Cards
        if (gameHistory.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No games played yet.",
                    color = TextMuted,
                    fontSize = 14.sp
                )
            }
        } else {
            gameHistory.forEach { record ->
                val isSelected = (record.id == activeRecord?.id)
                GameHistoryBannerCard(
                    record = record,
                    isSelected = isSelected,
                    onSelect = { selectedRecordId = record.id }
                )
            }
        }
    }
}

@Composable
fun GameHistoryBannerCard(
    record: GameHistoryRecord,
    isSelected: Boolean = false,
    onSelect: () -> Unit = {}
) {
    val tagColor = getTitleTagColor(record.titleTag)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable { onSelect() }
            .border(
                width = if (isSelected) 2.dp else 1.2.dp,
                brush = Brush.horizontalGradient(
                    if (isSelected) listOf(NeonCyan, NeonYellow)
                    else listOf(tagColor.copy(alpha = 0.8f), CyberCardBorder, tagColor.copy(alpha = 0.4f))
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .testTag("game_history_card_${record.id}"),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) CyberSurfaceVariant else CyberSurface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            // Header Row: Game Name, Selected Checkmark & Title Tag Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(
                                if (isSelected) NeonCyan.copy(alpha = 0.25f)
                                else Color(0xFFFF7A00).copy(alpha = 0.18f)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(getGameIcon(record.gameName), fontSize = 16.sp)
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = record.gameName,
                                color = TextPrimary,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.weight(1f, fill = false)
                            )
                            if (isSelected) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Box(
                                    modifier = Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(NeonCyan)
                                        .padding(horizontal = 6.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "✓ VIEWING",
                                        color = Color.Black,
                                        fontSize = 9.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                        }
                        Text(
                            text = "🕒 ${record.timestamp}",
                            color = TextMuted,
                            fontSize = 10.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.width(6.dp))

                // Title Tag Badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(tagColor.copy(alpha = 0.2f))
                        .border(1.dp, tagColor, RoundedCornerShape(12.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = record.titleTag,
                        color = tagColor,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 0.5.sp,
                        maxLines = 1
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(color = CyberCardBorder.copy(alpha = 0.6f))
            Spacer(modifier = Modifier.height(10.dp))

            // Stars Row & Score Stats
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Stars Display (5 stars)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    for (i in 1..5) {
                        Text(
                            text = if (i <= record.stars) "⭐" else "☆",
                            fontSize = 16.sp,
                            color = if (i <= record.stars) NeonGold else TextMuted
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "(${record.stars}/5)",
                        color = TextSecondary,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                // Score Badge
                Text(
                    text = "${record.score} Points",
                    color = NeonCyan,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Sub Stats Pill Row (Accuracy + Streak)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(8.dp))
                        .background(CyberSurfaceVariant)
                        .padding(horizontal = 8.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "🎯 Accuracy: ${record.accuracyText}",
                        color = TextPrimary,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(CyberSurfaceVariant)
                        .padding(horizontal = 8.dp, vertical = 5.dp)
                ) {
                    Text(
                        text = "🔥 Streak: ${record.highestStreak}",
                        color = Color(0xFFFF7A00),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

// Data models for Battle Arena
data class BattlePlayerData(
    val id: Int,
    var name: String,
    var score: Int = 0,
    val emoji: String,
    val themeColor: Color
)

data class BattleGameOption(
    val id: String,
    val name: String,
    val icon: String,
    var isSelected: Boolean
)

data class BattleQuestionData(
    val text: String,
    val options: List<String>,
    val correctAnswer: String,
    val gameIcon: String,
    val gameTitle: String
)

fun generateBattleQuestionData(gameId: String): BattleQuestionData {
    return when (gameId) {
        "REACTION" -> {
            val targets = listOf("🔴 RED TARGET", "🟢 GREEN TARGET", "🔵 BLUE TARGET", "🟡 YELLOW TARGET")
            val target = targets.random()
            val correctOpt = target
            val opts = targets.shuffled()
            BattleQuestionData(
                text = "⚡ REFLEX SPEED: TAP $target NOW!",
                options = opts,
                correctAnswer = correctOpt,
                gameIcon = "⚡",
                gameTitle = "Reaction Speed Reflex"
            )
        }
        "MEMORY" -> {
            val startNum = (1..10).random()
            val step = (2..5).random()
            val seq = listOf(startNum, startNum + step, startNum + step * 2, startNum + step * 3)
            val missingIndex = (0..3).random()
            val correctVal = seq[missingIndex]
            val displaySeq = seq.toMutableList().apply { set(missingIndex, -1) }
            val seqStr = displaySeq.joinToString(" • ") { if (it == -1) "?" else "$it" }

            val wrongOpts = mutableSetOf<Int>()
            while (wrongOpts.size < 3) {
                val dummy = correctVal + (-6..6).random()
                if (dummy != correctVal && dummy > 0) wrongOpts.add(dummy)
            }
            val opts = (wrongOpts.toList() + correctVal).shuffled().map { "$it" }

            BattleQuestionData(
                text = "🧠 MEMORY MATRIX: Find Missing Number\n[ $seqStr ]",
                options = opts,
                correctAnswer = "$correctVal",
                gameIcon = "🧠",
                gameTitle = "Memory Grid Matrix"
            )
        }
        "PATTERN" -> {
            val multi = (2..4).random()
            val base = (2..5).random()
            val p1 = base
            val p2 = base * multi
            val p3 = p2 * multi
            val p4 = p3 * multi
            val correctVal = p4

            val wrongOpts = mutableSetOf<Int>()
            while (wrongOpts.size < 3) {
                val dummy = correctVal + listOf(-10, -5, 5, 10, 15, -15).random()
                if (dummy != correctVal && dummy > 0) wrongOpts.add(dummy)
            }
            val opts = (wrongOpts.toList() + correctVal).shuffled().map { "$it" }

            BattleQuestionData(
                text = "🧩 PATTERN RECOGNITION: $p1, $p2, $p3, ?",
                options = opts,
                correctAnswer = "$correctVal",
                gameIcon = "🧩",
                gameTitle = "Pattern Recognition"
            )
        }
        else -> {
            // MATH
            val op = listOf("+", "-", "×").random()
            var n1 = 0
            var n2 = 0
            var ans = 0
            when (op) {
                "+" -> { n1 = (10..50).random(); n2 = (5..50).random(); ans = n1 + n2 }
                "-" -> { n1 = (20..99).random(); n2 = (5..n1).random(); ans = n1 - n2 }
                else -> { n1 = (3..12).random(); n2 = (3..12).random(); ans = n1 * n2 }
            }
            val wrongOpts = mutableSetOf<Int>()
            while (wrongOpts.size < 3) {
                val dummy = ans + listOf(-10, -2, -1, 1, 2, 5, 10).random()
                if (dummy != ans && dummy >= 0) wrongOpts.add(dummy)
            }
            val opts = (wrongOpts.toList() + ans).shuffled().map { "$it" }

            BattleQuestionData(
                text = "$n1  $op  $n2  =  ?",
                options = opts,
                correctAnswer = "$ans",
                gameIcon = "🔢",
                gameTitle = "Speed Math Calculation"
            )
        }
    }
}

@Composable
fun BattleTabScreen(
    onSaveBattleHistory: (GameHistoryRecord) -> Unit,
    onTryStartGame: (((() -> Unit)) -> Unit)? = null
) {
    val context = LocalContext.current

    // Player List State (2 to 4 Players)
    val players = remember {
        mutableStateListOf(
            BattlePlayerData(1, "Player 1", 0, "🅰️", Color(0xFFFF4444)),
            BattlePlayerData(2, "Player 2", 0, "🅱️", NeonCyan)
        )
    }

    // Available Games Selection List
    val gameOptions = remember {
        mutableStateListOf(
            BattleGameOption("MATH", "Math Speed Calculation", "🔢", true),
            BattleGameOption("REACTION", "Reaction Speed Reflex", "⚡", true),
            BattleGameOption("MEMORY", "Memory Grid Matrix", "🧠", false),
            BattleGameOption("PATTERN", "Pattern Recognition", "🧩", false)
        )
    }

    val playerColors = listOf(
        Color(0xFFCC3636), NeonCyan, NeonGreen, NeonGold, NeonPurpleBright,
        Color(0xFFCC6100), Color(0xFFCC0065), NeonYellow, Color(0xFF00B7CC), Color(0xFF00CC51)
    )
    val playerEmojis = listOf(
        "🅰️", "🅱️", "🟢", "🟡", "⭐", "⚡", "🔥", "💎", "🚀", "👑",
        "🎯", "👾", "🤖", "🦊", "🦁", "🐼", "🐲", "🔮", "🍕", "🏆"
    )

    // Game Mode: "MIXED" or "SEPARATE"
    var selectedBattleMode by remember { mutableStateOf("MIXED") } // "MIXED" vs "SEPARATE"

    // Custom Room / Bluetooth & Wi-Fi Hotspot Radar States
    var showCustomRoomDialog by remember { mutableStateOf(false) }
    var customTargetPlayers by remember { mutableIntStateOf(2) }
    var isScanningDevices by remember { mutableStateOf(false) }
    var discoveredCount by remember { mutableIntStateOf(0) }

    // Match Gameplay States
    var isBattleActive by remember { mutableStateOf(false) }

    DisposableEffect(isBattleActive) {
        if (isBattleActive) {
            RelaxingBgmPlayer.startBgm()
        } else {
            RelaxingBgmPlayer.stopBgm()
        }
        onDispose {
            RelaxingBgmPlayer.stopBgm()
        }
    }
    var activePlayerIndex by remember { mutableStateOf(0) }
    var currentRound by remember { mutableStateOf(1) } // 1 to 5 rounds per player
    val maxRoundsPerPlayer = 5

    var showPassDeviceOverlay by remember { mutableStateOf(false) }
    var isMatchFinished by remember { mutableStateOf(false) }
    var isHistorySaved by remember { mutableStateOf(false) }

    var currentQuestionData by remember { mutableStateOf<BattleQuestionData?>(null) }
    var turnFeedbackMessage by remember { mutableStateOf<String?>(null) }

    // Helper to get active question based on selected games and mode
    val generateNextQuestionForActivePlayer = {
        val selectedGames = gameOptions.filter { it.isSelected }
        val chosenGame = if (selectedGames.isNotEmpty()) selectedGames.random() else gameOptions[0]
        currentQuestionData = generateBattleQuestionData(chosenGame.id)
        turnFeedbackMessage = null
    }

    val launchBattleMatch = {
        // Reset player scores
        players.forEach { it.score = 0 }
        activePlayerIndex = 0
        currentRound = 1
        isMatchFinished = false
        isHistorySaved = false
        showPassDeviceOverlay = false
        isBattleActive = true
        generateNextQuestionForActivePlayer()
    }

    val startNewTournament = {
        if (onTryStartGame != null && !isBattleActive) {
            onTryStartGame(launchBattleMatch)
        } else {
            launchBattleMatch()
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Top Multiplayer Header Banner Card (Clean Title with Custom Room & Radar Option)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 1.dp,
                    brush = Brush.horizontalGradient(
                        listOf(Color(0xFFFF4444), NeonGold, NeonCyan, NeonPurpleBright)
                    ),
                    shape = RoundedCornerShape(16.dp)
                )
                .testTag("battle_arena_header"),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(NeonGold.copy(alpha = 0.2f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("⚔️", fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "MULTIPLAYER BRAIN ARENA",
                                color = TextPrimary,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 0.5.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Text(
                                text = "Live Multiplayer Tournament (2 to 100 Players)",
                                color = TextSecondary,
                                fontSize = 9.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }





















        if (!isBattleActive) {
            // SETUP / REGISTRATION SCREEN
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberSurface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Header with + Add Player button
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "PLAYERS REGISTRATION",
                                color = NeonCyan,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = "Add up to 100 players to battle",
                                color = TextMuted,
                                fontSize = 9.sp
                            )
                        }

                        if (players.size < 100) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(NeonGreen)
                                    .clickable {
                                        val newId = players.size + 1
                                        val color = playerColors[(newId - 1) % playerColors.size]
                                        val emoji = playerEmojis[(newId - 1) % playerEmojis.size]
                                        players.add(
                                            BattlePlayerData(
                                                id = newId,
                                                name = "Player $newId",
                                                score = 0,
                                                emoji = emoji,
                                                themeColor = color
                                            )
                                        )
                                    }
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text("➕", fontSize = 10.sp)
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = "ADD PLAYER ${players.size + 1}",
                                        color = Color.Black,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                        }
                    }

                    // Player Inputs List
                    players.forEachIndexed { index, player ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(CyberSurfaceVariant)
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(player.themeColor.copy(alpha = 0.25f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(player.emoji, fontSize = 12.sp)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            OutlinedTextField(
                                value = player.name,
                                onValueChange = { newName -> players[index] = player.copy(name = newName) },
                                label = { Text("Player ${index + 1} Name", color = TextMuted, fontSize = 9.sp) },
                                singleLine = true,
                                modifier = Modifier.weight(1f),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = player.themeColor,
                                    unfocusedBorderColor = CyberCardBorder,
                                    focusedTextColor = TextPrimary,
                                    unfocusedTextColor = TextPrimary
                                )
                            )

                            if (players.size > 2) {
                                Spacer(modifier = Modifier.width(4.dp))
                                IconButton(
                                    onClick = { players.removeAt(index) },
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Text("🗑️", fontSize = 12.sp)
                                }
                            }
                        }
                    }

                    HorizontalDivider(color = CyberCardBorder)

                    // SELECT GAMES LIST
                    Text(
                        text = "SELECT TOURNAMENT GAMES",
                        color = NeonGold,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        gameOptions.forEachIndexed { gIdx, gOpt ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(CyberSurfaceVariant)
                                    .border(
                                        1.dp,
                                        if (gOpt.isSelected) NeonCyan else CyberCardBorder,
                                        RoundedCornerShape(10.dp)
                                    )
                                    .clickable {
                                        val countSelected = gameOptions.count { it.isSelected }
                                        if (gOpt.isSelected && countSelected <= 1) {
                                            Toast.makeText(context, "At least 1 game must be selected!", Toast.LENGTH_SHORT).show()
                                        } else {
                                            gameOptions[gIdx] = gOpt.copy(isSelected = !gOpt.isSelected)
                                        }
                                    }
                                    .padding(horizontal = 12.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(gOpt.icon, fontSize = 18.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = gOpt.name,
                                        color = TextPrimary,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clip(RoundedCornerShape(4.dp))
                                        .background(if (gOpt.isSelected) NeonCyan else Color.Transparent)
                                        .border(1.dp, if (gOpt.isSelected) NeonCyan else TextMuted, RoundedCornerShape(4.dp)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (gOpt.isSelected) {
                                        Text("✓", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Black)
                                    }
                                }
                            }
                        }
                    }

                    // GAME PLAY MODE (MIXED vs SEPARATE)
                    Text(
                        text = "TOURNAMENT GAME MODE",
                        color = NeonYellow,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        listOf(
                            "MIXED" to "🔀 MIXED MODE",
                            "SEPARATE" to "📋 SEPARATE ROUNDS"
                        ).forEach { (modeKey, modeTitle) ->
                            val isSel = selectedBattleMode == modeKey
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(CyberSurfaceVariant)
                                    .border(1.dp, if (isSel) NeonCyan else CyberCardBorder, RoundedCornerShape(8.dp))
                                    .clickable { selectedBattleMode = modeKey }
                                    .padding(vertical = 8.dp, horizontal = 6.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = modeTitle,
                                    color = if (isSel) NeonGreen else TextSecondary,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    // START TOURNAMENT BUTTON
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                Brush.horizontalGradient(
                                    listOf(Color(0xFFFF4444), NeonGold, NeonCyan)
                                )
                            )
                            .clickable { startNewTournament() }
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("⚔️", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "START TOURNAMENT BATTLE",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 0.5.sp
                            )
                        }
                    }
                }
            }
        } else if (isMatchFinished) {
            // LEADERBOARD / VICTORY PODIUM SCREEN
            val sortedPlayers = players.sortedByDescending { it.score }
            val winner = sortedPlayers.firstOrNull()

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, NeonGold, RoundedCornerShape(20.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberSurface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text("👑", fontSize = 48.sp)

                    Text(
                        text = "🏆 ${winner?.name ?: "WINNER"} IS THE CHAMPION!",
                        color = NeonGold,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center
                    )

                    HorizontalDivider(color = CyberCardBorder)

                    Text(
                        text = "FINAL LEADERBOARD STANDINGS",
                        color = NeonCyan,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.5.sp
                    )

                    // Leaderboard Ranks
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        sortedPlayers.forEachIndexed { rank, p ->
                            val rankBadges = listOf("🥇 1st", "🥈 2nd", "🥉 3rd", "🎖️ 4th")
                            val rankColor = when (rank) {
                                0 -> NeonGold
                                1 -> NeonCyan
                                2 -> Color(0xFFFF7A00)
                                else -> TextMuted
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(if (rank == 0) rankColor.copy(alpha = 0.2f) else CyberSurfaceVariant)
                                    .border(1.dp, if (rank == 0) rankColor else CyberCardBorder, RoundedCornerShape(12.dp))
                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(rankBadges.getOrElse(rank) { "🎖️ ${rank + 1}th" }, fontSize = 14.sp, fontWeight = FontWeight.Black, color = rankColor)
                                    Spacer(modifier = Modifier.width(10.dp))
                                    Text(p.emoji, fontSize = 16.sp)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(p.name, color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }

                                Text("${p.score} Pts", color = rankColor, fontSize = 15.sp, fontWeight = FontWeight.Black)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Save History Button
                    if (!isHistorySaved) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(NeonCyan)
                                .clickable {
                                    isHistorySaved = true
                                    val topScore = winner?.score ?: 0
                                    val nowFormatted = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
                                    val summaryStr = sortedPlayers.joinToString(", ") { "${it.name}: ${it.score}pts" }
                                    val record = GameHistoryRecord(
                                        gameName = "Multiplayer Battle (${players.size} Players)",
                                        score = topScore,
                                        stars = 5,
                                        titleTag = "ARENA KING",
                                        accuracyText = summaryStr,
                                        highestStreak = topScore / 10,
                                        timestamp = "Today, $nowFormatted"
                                    )
                                    onSaveBattleHistory(record)
                                    Toast.makeText(context, "Battle result saved to Progress!", Toast.LENGTH_SHORT).show()
                                }
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "💾 SAVE BATTLE RECORD TO PROGRESS",
                                color = Color.Black,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black
                            )
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(NeonGreen.copy(alpha = 0.2f))
                                .border(1.dp, NeonGreen, RoundedCornerShape(12.dp))
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "✓ RESULT SAVED IN PROGRESS TAB",
                                color = NeonGreen,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    // Rematch / Exit Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .background(CyberSurfaceVariant)
                                .clickable { isBattleActive = false }
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("EXIT TO MENU", color = TextSecondary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }

                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    Brush.horizontalGradient(
                                        listOf(Color(0xFFFF7A00), NeonYellow)
                                    )
                                )
                                .clickable { startNewTournament() }
                                .padding(vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("REMATCH BATTLE", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Black)
                        }
                    }
                }
            }
        } else if (showPassDeviceOverlay) {
            // PASS DEVICE TO NEXT PLAYER OVERLAY
            val nextPlayer = players.getOrNull(activePlayerIndex)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, nextPlayer?.themeColor ?: NeonCyan, RoundedCornerShape(20.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberSurface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text("📱", fontSize = 48.sp)

                    Text(
                        text = "PASS DEVICE TO ${nextPlayer?.name?.uppercase()}",
                        color = nextPlayer?.themeColor ?: NeonCyan,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        text = "It's ${nextPlayer?.name}'s Turn! Get Ready!",
                        color = TextSecondary,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(14.dp))
                            .background(nextPlayer?.themeColor ?: NeonCyan)
                            .clickable {
                                showPassDeviceOverlay = false
                                generateNextQuestionForActivePlayer()
                            }
                            .padding(vertical = 14.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "READY! START MY TURN",
                            color = Color.Black,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                }
            }
        } else {
            // LIVE GAMEPLAY INTERFACE
            val activeP = players.getOrElse(activePlayerIndex) { players[0] }
            val qData = currentQuestionData ?: generateBattleQuestionData("MATH")

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(1.5.dp, activeP.themeColor, RoundedCornerShape(20.dp)),
                colors = CardDefaults.cardColors(containerColor = CyberSurface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Scoreboard Strip for all players (Scrollable horizontally for up to 100 players)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        players.forEachIndexed { pIdx, p ->
                            val isActiveP = (pIdx == activePlayerIndex)
                            Box(
                                modifier = Modifier
                                    .widthIn(min = 85.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(if (isActiveP) p.themeColor.copy(alpha = 0.25f) else CyberSurfaceVariant)
                                    .border(1.dp, if (isActiveP) p.themeColor else CyberCardBorder, RoundedCornerShape(10.dp))
                                    .padding(vertical = 8.dp, horizontal = 10.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text("${p.emoji} ${p.name}", color = if (isActiveP) p.themeColor else TextMuted, fontSize = 10.sp, fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                    Text("${p.score} pts", color = TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.Black)
                                }
                            }
                        }
                    }

                    // Turn Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(qData.gameIcon, fontSize = 16.sp)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(qData.gameTitle, color = TextSecondary, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }

                        Text(
                            text = "ROUND $currentRound / $maxRoundsPerPlayer",
                            color = NeonGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Black
                        )
                    }

                    // Active Player Turn Banner
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(activeP.themeColor.copy(alpha = 0.2f))
                            .border(1.2.dp, activeP.themeColor, RoundedCornerShape(12.dp))
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "⚡ ${activeP.name}'s TURN (${activeP.emoji})",
                            color = activeP.themeColor,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }

                    // Question Box
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(CyberSurfaceVariant),
                        colors = CardDefaults.cardColors(containerColor = CyberSurfaceVariant)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = qData.text,
                                color = TextPrimary,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Black,
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    // Feedback Message
                    turnFeedbackMessage?.let { msg ->
                        Text(
                            text = msg,
                            color = NeonYellow,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    // Options Grid (2x2)
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        val opts = qData.options
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            for (i in 0..1) {
                                val optValue = opts.getOrElse(i) { "" }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(CyberSurfaceVariant)
                                        .border(1.2.dp, activeP.themeColor.copy(alpha = 0.6f), RoundedCornerShape(14.dp))
                                        .clickable {
                                            val isCorrect = (optValue == qData.correctAnswer)
                                            if (isCorrect) {
                                                activeP.score += 10
                                                turnFeedbackMessage = "✅ Correct! +10 Points to ${activeP.name}"
                                            } else {
                                                turnFeedbackMessage = "❌ Wrong! Correct was ${qData.correctAnswer}"
                                            }

                                            // Advance active player's round
                                            if (currentRound < maxRoundsPerPlayer) {
                                                currentRound++
                                                generateNextQuestionForActivePlayer()
                                            } else {
                                                // Active player finished ALL rounds! Move to next player
                                                if (activePlayerIndex < players.size - 1) {
                                                    activePlayerIndex++
                                                    currentRound = 1
                                                    showPassDeviceOverlay = true
                                                } else {
                                                    // ALL PLAYERS COMPLETED ALL ROUNDS!
                                                    isMatchFinished = true
                                                }
                                            }
                                        }
                                        .padding(vertical = 14.dp, horizontal = 8.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = optValue,
                                        color = TextPrimary,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            for (i in 2..3) {
                                val optValue = opts.getOrElse(i) { "" }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(CyberSurfaceVariant)
                                        .border(1.2.dp, activeP.themeColor.copy(alpha = 0.6f), RoundedCornerShape(14.dp))
                                        .clickable {
                                            val isCorrect = (optValue == qData.correctAnswer)
                                            if (isCorrect) {
                                                activeP.score += 10
                                                turnFeedbackMessage = "✅ Correct! +10 Points to ${activeP.name}"
                                            } else {
                                                turnFeedbackMessage = "❌ Wrong! Correct was ${qData.correctAnswer}"
                                            }

                                            // Advance active player's round
                                            if (currentRound < maxRoundsPerPlayer) {
                                                currentRound++
                                                generateNextQuestionForActivePlayer()
                                            } else {
                                                // Active player finished ALL rounds! Move to next player
                                                if (activePlayerIndex < players.size - 1) {
                                                    activePlayerIndex++
                                                    currentRound = 1
                                                    showPassDeviceOverlay = true
                                                } else {
                                                    // ALL PLAYERS COMPLETED ALL ROUNDS!
                                                    isMatchFinished = true
                                                }
                                            }
                                        }
                                        .padding(vertical = 14.dp, horizontal = 8.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = optValue,
                                        color = TextPrimary,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun generateRandomMathQuestion(): MathQuestion {
    val operators = listOf("+", "-", "×", "÷")
    val op = operators.random()
    var num1 = 0
    var num2 = 0
    var answer = 0

    when (op) {
        "+" -> {
            num1 = (10..99).random()
            num2 = (5..99).random()
            answer = num1 + num2
        }
        "-" -> {
            num1 = (25..99).random()
            num2 = (5..num1).random()
            answer = num1 - num2
        }
        "×" -> {
            num1 = (3..12).random()
            num2 = (3..15).random()
            answer = num1 * num2
        }
        else -> { // ÷
            num2 = (2..12).random()
            val multiplier = (2..12).random()
            num1 = num2 * multiplier
            answer = multiplier
        }
    }

    val optionsSet = mutableSetOf(answer)
    while (optionsSet.size < 4) {
        val offset = listOf(-10, -5, -2, -1, 1, 2, 5, 10, 15, -15).random()
        val wrong = answer + offset
        if (wrong != answer && wrong >= 0) {
            optionsSet.add(wrong)
        } else {
            optionsSet.add(answer + (1..20).random())
        }
    }

    return MathQuestion(
        questionText = "$num1  $op  $num2  =  ?",
        correctAnswer = answer,
        options = optionsSet.toList().shuffled()
    )
}

@Composable
fun MathGameDialog(
    onDismiss: () -> Unit,
    onGameFinished: (GameHistoryRecord) -> Unit = {}
) {
    DisposableEffect(Unit) {
        RelaxingBgmPlayer.startBgm()
        onDispose {
            RelaxingBgmPlayer.stopBgm()
        }
    }

    var score by remember { mutableStateOf(0) }
    var streak by remember { mutableStateOf(0) }
    var highestStreak by remember { mutableStateOf(0) }
    var totalQuestions by remember { mutableStateOf(0) }
    var correctAnswers by remember { mutableStateOf(0) }
    var timeLeft by remember { mutableStateOf(30) }
    var isGameOver by remember { mutableStateOf(false) }
    var hasSavedHistory by remember { mutableStateOf(false) }

    var currentQuestion by remember { mutableStateOf(generateRandomMathQuestion()) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var isAnswerCorrect by remember { mutableStateOf<Boolean?>(null) }

    // Countdown Timer Loop
    LaunchedEffect(key1 = isGameOver) {
        if (!isGameOver) {
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft--
            }
            isGameOver = true
        }
    }

    // Save Game Record to History when Game Over triggers
    LaunchedEffect(key1 = isGameOver) {
        if (isGameOver && !hasSavedHistory) {
            hasSavedHistory = true
            val (stars, titleTag) = calculateGameRating(score)
            val nowFormatted = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
            val record = GameHistoryRecord(
                gameName = "Math Speed Calculation",
                score = score,
                stars = stars,
                titleTag = titleTag,
                accuracyText = "$correctAnswers / $totalQuestions Correct",
                highestStreak = highestStreak,
                timestamp = "Today, $nowFormatted"
            )
            onGameFinished(record)
        }
    }

    // Delay auto-advance after selecting answer
    LaunchedEffect(key1 = selectedOption) {
        if (selectedOption != null) {
            delay(700L)
            if (!isGameOver) {
                currentQuestion = generateRandomMathQuestion()
                selectedOption = null
                isAnswerCorrect = null
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.85f))
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(24.dp))
                    .border(
                        width = 1.5.dp,
                        brush = Brush.linearGradient(
                            listOf(Color(0xFFFF7A00), NeonCyan, NeonPurpleBright)
                        ),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .testTag("math_game_card"),
                colors = CardDefaults.cardColors(containerColor = CyberSurface)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Header Bar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFFF7A00).copy(alpha = 0.2f)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("🔢", fontSize = 18.sp)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(
                                    text = "MATH BRAIN TRAINER",
                                    color = TextPrimary,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Text(
                                    text = "Math Speed Calculation",
                                    color = TextSecondary,
                                    fontSize = 10.sp
                                )
                            }
                        }

                        IconButton(
                            onClick = onDismiss,
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(CyberSurfaceVariant)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close",
                                tint = TextPrimary,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    if (isGameOver) {
                        // Game Over / Result Screen
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp)
                        ) {
                            Text("🏁", fontSize = 42.sp)
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "TIME UP!",
                                color = NeonGold,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.height(14.dp))

                            // Score stats card
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(CyberSurfaceVariant)
                                    .padding(16.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Total Score:", color = TextSecondary, fontSize = 13.sp)
                                    Text("$score Points", color = NeonCyan, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                }
                                HorizontalDivider(color = CyberCardBorder)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Correct Answers:", color = TextSecondary, fontSize = 13.sp)
                                    Text("$correctAnswers / $totalQuestions", color = NeonGreen, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                }
                                HorizontalDivider(color = CyberCardBorder)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Max Streak:", color = TextSecondary, fontSize = 13.sp)
                                    Text("🔥 $highestStreak", color = Color(0xFFFF7A00), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                }
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(
                                            Brush.horizontalGradient(
                                                listOf(Color(0xFFFF7A00), NeonYellow)
                                            )
                                        )
                                        .clickable {
                                            // Restart Game
                                            score = 0
                                            streak = 0
                                            highestStreak = 0
                                            totalQuestions = 0
                                            correctAnswers = 0
                                            timeLeft = 30
                                            isGameOver = false
                                            hasSavedHistory = false
                                            currentQuestion = generateRandomMathQuestion()
                                            selectedOption = null
                                            isAnswerCorrect = null
                                        }
                                        .padding(vertical = 12.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("PLAY AGAIN", color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Black)
                                }

                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(CyberSurfaceVariant)
                                        .border(1.dp, CyberCardBorder, RoundedCornerShape(12.dp))
                                        .clickable { onDismiss() }
                                        .padding(vertical = 12.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("CLOSE", color = TextPrimary, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    } else {
                        // Gameplay view
                        // Stats Header: Score, Streak, Timer
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(14.dp))
                                .background(CyberSurfaceVariant)
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text("Score", color = TextMuted, fontSize = 10.sp)
                                Text("$score", color = NeonCyan, fontSize = 16.sp, fontWeight = FontWeight.Black)
                            }

                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text("Time", color = TextMuted, fontSize = 10.sp)
                                Text(
                                    text = "${timeLeft}s",
                                    color = if (timeLeft <= 5) Color(0xFFFF4444) else NeonYellow,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            Column(horizontalAlignment = Alignment.End) {
                                Text("Streak", color = TextMuted, fontSize = 10.sp)
                                Text("🔥 $streak", color = Color(0xFFFF7A00), fontSize = 16.sp, fontWeight = FontWeight.Black)
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Timer Progress bar
                        LinearProgressIndicator(
                            progress = { timeLeft / 30f },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = if (timeLeft <= 5) Color(0xFFFF4444) else Color(0xFFFF7A00),
                            trackColor = CyberBackground
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        // Question Display Box
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(110.dp)
                                .clip(RoundedCornerShape(18.dp))
                                .background(
                                    Brush.verticalGradient(
                                        listOf(
                                            CyberBackground,
                                            CyberSurfaceVariant
                                        )
                                    )
                                )
                                .border(
                                    width = 1.5.dp,
                                    color = when (isAnswerCorrect) {
                                        true -> NeonGreen
                                        false -> Color(0xFFFF4444)
                                        null -> Color(0xFFFF7A00).copy(alpha = 0.6f)
                                    },
                                    shape = RoundedCornerShape(18.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = currentQuestion.questionText,
                                    color = TextPrimary,
                                    fontSize = 28.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )

                                if (isAnswerCorrect != null) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = if (isAnswerCorrect == true) "✓ सही जवाब! (+10)" else "✗ गलत जवाब!",
                                        color = if (isAnswerCorrect == true) NeonGreen else Color(0xFFFF4444),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // Options Grid (4 options)
                        val options = currentQuestion.options
                        Column(
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OptionButton(
                                    optionValue = options.getOrNull(0) ?: 0,
                                    correctAnswer = currentQuestion.correctAnswer,
                                    selectedOption = selectedOption,
                                    modifier = Modifier.weight(1f),
                                    onSelect = { option ->
                                        if (selectedOption == null) {
                                            selectedOption = option
                                            totalQuestions++
                                            val correct = option == currentQuestion.correctAnswer
                                            isAnswerCorrect = correct
                                            if (correct) {
                                                score += 10 + (streak * 2)
                                                streak++
                                                if (streak > highestStreak) highestStreak = streak
                                                correctAnswers++
                                            } else {
                                                streak = 0
                                            }
                                        }
                                    }
                                )

                                OptionButton(
                                    optionValue = options.getOrNull(1) ?: 0,
                                    correctAnswer = currentQuestion.correctAnswer,
                                    selectedOption = selectedOption,
                                    modifier = Modifier.weight(1f),
                                    onSelect = { option ->
                                        if (selectedOption == null) {
                                            selectedOption = option
                                            totalQuestions++
                                            val correct = option == currentQuestion.correctAnswer
                                            isAnswerCorrect = correct
                                            if (correct) {
                                                score += 10 + (streak * 2)
                                                streak++
                                                if (streak > highestStreak) highestStreak = streak
                                                correctAnswers++
                                            } else {
                                                streak = 0
                                            }
                                        }
                                    }
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                OptionButton(
                                    optionValue = options.getOrNull(2) ?: 0,
                                    correctAnswer = currentQuestion.correctAnswer,
                                    selectedOption = selectedOption,
                                    modifier = Modifier.weight(1f),
                                    onSelect = { option ->
                                        if (selectedOption == null) {
                                            selectedOption = option
                                            totalQuestions++
                                            val correct = option == currentQuestion.correctAnswer
                                            isAnswerCorrect = correct
                                            if (correct) {
                                                score += 10 + (streak * 2)
                                                streak++
                                                if (streak > highestStreak) highestStreak = streak
                                                correctAnswers++
                                            } else {
                                                streak = 0
                                            }
                                        }
                                    }
                                )

                                OptionButton(
                                    optionValue = options.getOrNull(3) ?: 0,
                                    correctAnswer = currentQuestion.correctAnswer,
                                    selectedOption = selectedOption,
                                    modifier = Modifier.weight(1f),
                                    onSelect = { option ->
                                        if (selectedOption == null) {
                                            selectedOption = option
                                            totalQuestions++
                                            val correct = option == currentQuestion.correctAnswer
                                            isAnswerCorrect = correct
                                            if (correct) {
                                                score += 10 + (streak * 2)
                                                streak++
                                                if (streak > highestStreak) highestStreak = streak
                                                correctAnswers++
                                            } else {
                                                streak = 0
                                            }
                                        }
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OptionButton(
    optionValue: Int,
    correctAnswer: Int,
    selectedOption: Int?,
    modifier: Modifier = Modifier,
    onSelect: (Int) -> Unit
) {
    val isSelected = selectedOption == optionValue
    val isCorrect = optionValue == correctAnswer

    val bgColor = when {
        selectedOption == null -> CyberSurfaceVariant
        isCorrect -> NeonGreen.copy(alpha = 0.25f)
        isSelected && !isCorrect -> Color(0xFFFF4444).copy(alpha = 0.25f)
        else -> CyberSurfaceVariant.copy(alpha = 0.4f)
    }

    val borderColor = when {
        selectedOption == null -> CyberCardBorder
        isCorrect -> NeonGreen
        isSelected && !isCorrect -> Color(0xFFFF4444)
        else -> CyberCardBorder.copy(alpha = 0.4f)
    }

    val textColor = when {
        selectedOption == null -> TextPrimary
        isCorrect -> NeonGreen
        isSelected && !isCorrect -> Color(0xFFFF4444)
        else -> TextMuted
    }

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(14.dp))
            .background(bgColor)
            .border(1.2.dp, borderColor, RoundedCornerShape(14.dp))
            .clickable { onSelect(optionValue) }
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$optionValue",
            color = textColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@Composable
fun MemoryGameDialog(
    onDismiss: () -> Unit,
    onGameFinished: (GameHistoryRecord) -> Unit = {}
) {
    DisposableEffect(Unit) {
        RelaxingBgmPlayer.startBgm()
        onDispose {
            RelaxingBgmPlayer.stopBgm()
        }
    }

    // Dynamic level & infinite procedural grid progression (Matiks style)
    var level by remember { mutableStateOf(1) }
    var score by remember { mutableStateOf(0) }
    var mistakes by remember { mutableStateOf(0) }
    val maxMistakes = 3

    var rows by remember { mutableStateOf(3) }
    var cols by remember { mutableStateOf(3) }
    var targetCount by remember { mutableStateOf(3) }

    var isGameOver by remember { mutableStateOf(false) }
    var showGameOverPopup by remember { mutableStateOf(false) }
    var showExitConfirmationDialog by remember { mutableStateOf(false) }
    var isDisappearing by remember { mutableStateOf(false) }
    var hasSavedHistory by remember { mutableStateOf(false) }

    // Procedural Infinite Level Generation Engine (Progression over 100 levels)
    fun updateGridForLevel(lvl: Int) {
        when {
            lvl in 1..3 -> { rows = 3; cols = 3; targetCount = 3 }
            lvl in 4..7 -> { rows = 3; cols = 3; targetCount = 4 }
            lvl in 8..10 -> { rows = 3; cols = 3; targetCount = 5 }
            lvl in 11..15 -> { rows = 3; cols = 4; targetCount = 4 }
            lvl in 16..20 -> { rows = 3; cols = 4; targetCount = 5 }
            lvl in 21..25 -> { rows = 4; cols = 4; targetCount = 5 }
            lvl in 26..30 -> { rows = 4; cols = 4; targetCount = 6 }
            lvl in 31..35 -> { rows = 4; cols = 5; targetCount = 6 }
            lvl in 36..40 -> { rows = 4; cols = 5; targetCount = 7 }
            lvl in 41..45 -> { rows = 5; cols = 5; targetCount = 7 }
            lvl in 46..50 -> { rows = 5; cols = 5; targetCount = 8 }
            lvl in 51..55 -> { rows = 5; cols = 6; targetCount = 8 }
            lvl in 56..60 -> { rows = 5; cols = 6; targetCount = 9 }
            lvl in 61..65 -> { rows = 6; cols = 6; targetCount = 10 }
            lvl in 66..70 -> { rows = 6; cols = 6; targetCount = 12 }
            lvl in 71..75 -> { rows = 6; cols = 7; targetCount = 12 }
            lvl in 76..80 -> { rows = 6; cols = 7; targetCount = 14 }
            lvl in 81..85 -> { rows = 7; cols = 7; targetCount = 15 }
            lvl in 86..90 -> { rows = 7; cols = 7; targetCount = 17 }
            lvl in 91..95 -> { rows = 7; cols = 8; targetCount = 18 }
            lvl in 96..100 -> { rows = 7; cols = 8; targetCount = 20 }
            else -> {
                rows = 8
                cols = 8
                targetCount = (20 + (lvl - 100) / 10).coerceAtMost(32)
            }
        }
    }

    // Targets and clicked states
    var targetCells by remember { mutableStateOf(emptySet<Int>()) }
    val clickedCells = remember { mutableStateListOf<Int>() }
    val failedCells = remember { mutableStateListOf<Int>() }

    var isPreviewPhase by remember { mutableStateOf(true) }
    var previewTimeLeft by remember { mutableStateOf(1.2f) }

    // Dynamic preview duration so higher levels with more targets get enough time
    fun getMaxPreviewTime(): Float = (1.2f + (targetCount - 3) * 0.12f).coerceIn(1.2f, 3.5f)

    var isLevelCleared by remember { mutableStateOf(false) }

    // Helper generator function to start a level
    fun startNewLevel() {
        updateGridForLevel(level)
        clickedCells.clear()
        failedCells.clear()
        isLevelCleared = false
        isDisappearing = false
        showGameOverPopup = false

        val currentTotal = rows * cols
        val targetSet = mutableSetOf<Int>()
        val numIsolated = if (targetCount > 4) (0..2).random() else (0..1).random()
        val clusterSize = (targetCount - numIsolated).coerceAtLeast(1)

        val cluster = mutableSetOf<Int>()
        val firstCell = (0 until currentTotal).random()
        cluster.add(firstCell)

        fun getNeighbors(cell: Int): List<Int> {
            val r = cell / cols
            val c = cell % cols
            val neighbors = mutableListOf<Int>()
            if (r > 0) neighbors.add((r - 1) * cols + c)
            if (r < rows - 1) neighbors.add((r + 1) * cols + c)
            if (c > 0) neighbors.add(r * cols + (c - 1))
            if (c < cols - 1) neighbors.add(r * cols + (c + 1))
            return neighbors
        }

        while (cluster.size < clusterSize) {
            val candidates = cluster.flatMap { getNeighbors(it) }.filter { it !in cluster }
            if (candidates.isEmpty()) break
            cluster.add(candidates.random())
        }
        targetSet.addAll(cluster)

        val remainingCount = targetCount - targetSet.size
        if (remainingCount > 0) {
            val available = (0 until currentTotal).filter { it !in targetSet }
            if (available.isNotEmpty()) {
                targetSet.addAll(available.shuffled().take(remainingCount))
            }
        }

        targetCells = targetSet
        isPreviewPhase = true
    }

    // Trigger level initialization
    LaunchedEffect(level) {
        startNewLevel()
    }

    // Half-time preview timer loop
    LaunchedEffect(key1 = level, key2 = isPreviewPhase, key3 = isGameOver) {
        if (!isGameOver && isPreviewPhase) {
            val duration = getMaxPreviewTime()
            previewTimeLeft = duration
            val steps = (duration * 10).toInt()
            for (i in steps downTo 1) {
                delay(100L)
                previewTimeLeft = i / 10.0f
            }
            isPreviewPhase = false
        }
    }

    // Save history on Game Over with 0.5s popup delay
    LaunchedEffect(key1 = isGameOver) {
        if (isGameOver) {
            delay(500L) // 0.5s delay before showing popup so red box & OUT! text display first
            showGameOverPopup = true
            if (!hasSavedHistory) {
                hasSavedHistory = true
                val (stars, titleTag) = calculateGameRating(score)
                val nowFormatted = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
                val record = GameHistoryRecord(
                    gameName = "Memory Grid Matrix (मेमोरी)",
                    score = level,
                    stars = stars,
                    titleTag = "Level $level Reached",
                    accuracyText = "Score: $score",
                    highestStreak = level,
                    timestamp = "Today, $nowFormatted"
                )
                onGameFinished(record)
            }
        } else {
            showGameOverPopup = false
        }
    }

    // Clear level transition (0.5s disappear animation before starting next level)
    LaunchedEffect(key1 = isLevelCleared) {
        if (isLevelCleared) {
            isDisappearing = true
            delay(500L) // 0.5s disappear animation
            score += 25 // 25 XP per level
            level++
            startNewLevel()
            isDisappearing = false
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    ) {
        // Full screen modern interface with absolute black theme
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212))
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(24.dp)
        ) {
            // Main Game Board View
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // 1. Sleek Top Bar HUD
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { showExitConfirmationDialog = true },
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF1E1E1E))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Exit",
                            tint = TextPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    // Memory Grid Purple Badge
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(NeonPurpleBright.copy(alpha = 0.15f))
                            .border(1.dp, NeonPurpleBright.copy(alpha = 0.4f), RoundedCornerShape(20.dp))
                            .padding(horizontal = 14.dp, vertical = 6.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(NeonPurpleBright)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = "🧩 MEMORY GRID",
                                color = NeonPurpleBright,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                        }
                    }

                    // Lives Counter
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(maxMistakes) { index ->
                            val isLost = index < mistakes
                            Text(
                                text = if (isLost) "💀" else "❤️",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(horizontal = 2.dp)
                            )
                        }
                    }
                }

                // 2. HUD Info Panel
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("LEVEL", color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Text("$level", color = NeonGold, fontSize = 24.sp, fontWeight = FontWeight.Black)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("XP", color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Text("$score", color = Color(0xFF8CE2F3), fontSize = 24.sp, fontWeight = FontWeight.Black)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("GRID", color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                            Text("${rows}x${cols}", color = NeonPurpleBright, fontSize = 24.sp, fontWeight = FontWeight.Black)
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // In-Place Level / SUCCESSFUL! / OUT! Display (Zero layout shift)
                    val headerText = when {
                        isLevelCleared -> "SUCCESSFUL!"
                        isGameOver -> "OUT!"
                        else -> "$level"
                    }
                    val headerColor = when {
                        isLevelCleared -> NeonGreen
                        isGameOver -> Color(0xFFFF1744)
                        isPreviewPhase -> NeonGold
                        else -> Color(0xFF8CE2F3)
                    }

                    Text(
                        text = headerText,
                        color = headerColor,
                        fontSize = if (headerText.length > 3) 22.sp else 28.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.5.sp
                    )

                    // Countdown Progress line for preview
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(4.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF2C2C2C))
                    ) {
                        if (isPreviewPhase) {
                            LinearProgressIndicator(
                                progress = { previewTimeLeft / getMaxPreviewTime() },
                                modifier = Modifier.fillMaxSize(),
                                color = Color(0xFF8CE2F3),
                                trackColor = Color.Transparent
                            )
                        }
                    }
                }

                // 3. Grid strictly aligned TopCenter directly below level mark line
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(top = 12.dp, bottom = 16.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    val maxDim = maxOf(rows, cols)
                    val (cellSize, gridSpacing, cornerRadius) = when {
                        maxDim <= 3 -> Triple(72.dp, 12.dp, 14.dp)
                        maxDim == 4 -> Triple(64.dp, 10.dp, 12.dp)
                        maxDim == 5 -> Triple(54.dp, 8.dp, 10.dp)
                        maxDim == 6 -> Triple(46.dp, 6.dp, 8.dp)
                        maxDim == 7 -> Triple(40.dp, 5.dp, 7.dp)
                        else -> Triple(36.dp, 4.dp, 6.dp)
                    }

                    key(level) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(gridSpacing),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            repeat(rows) { rowIndex ->
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(gridSpacing)
                                ) {
                                    repeat(cols) { colIndex ->
                                        val cellIndex = rowIndex * cols + colIndex
                                        val isTarget = targetCells.contains(cellIndex)
                                        val isClicked = clickedCells.contains(cellIndex)
                                        val isFailed = failedCells.contains(cellIndex)

                                        // 0.5s Horizontal Flip Animation Spec
                                        val targetFlip = if ((isPreviewPhase && isTarget) || isClicked) 180f else 0f
                                        val flipRotation by animateFloatAsState(
                                            targetValue = targetFlip,
                                            animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
                                            label = "cardFlip"
                                        )

                                        // Disappear animation before next level
                                        val gridAlpha by animateFloatAsState(
                                            targetValue = if (isDisappearing) 0f else 1f,
                                            animationSpec = tween(durationMillis = 400, easing = LinearEasing),
                                            label = "gridDisappear"
                                        )

                                        val targetColor = Color(0xFF8CE2F3)
                                        val inactiveColor = Color(0xFF2C2C2C)
                                        val wrongColor = Color(0xFFFF1744)

                                        val cellColor = when {
                                            isFailed -> wrongColor
                                            flipRotation > 90f -> targetColor
                                            else -> inactiveColor
                                        }

                                        Box(
                                            modifier = Modifier
                                                .size(cellSize)
                                                .graphicsLayer {
                                                    alpha = gridAlpha
                                                    rotationY = flipRotation
                                                    cameraDistance = 12f * density
                                                }
                                                .clip(RoundedCornerShape(cornerRadius))
                                                .background(cellColor)
                                                .clickable(enabled = !isPreviewPhase && !isLevelCleared && !isClicked && !isFailed && !isGameOver && !isDisappearing) {
                                                    if (isTarget) {
                                                        clickedCells.add(cellIndex)
                                                        if (clickedCells.size == targetCells.size) {
                                                            isLevelCleared = true
                                                        }
                                                    } else {
                                                        failedCells.add(cellIndex)
                                                        mistakes++
                                                        if (mistakes >= maxMistakes) {
                                                            isGameOver = true
                                                        }
                                                    }
                                                }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // Confirm Exit Popup Dialog
            if (showExitConfirmationDialog) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.85f)),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .clip(RoundedCornerShape(20.dp))
                            .border(1.dp, NeonPurpleBright.copy(alpha = 0.5f), RoundedCornerShape(20.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF181824))
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("⚠️", fontSize = 36.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "QUIT GAME?",
                                color = TextPrimary,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "Are you sure you want to exit? Your game progress will be saved.",
                                color = TextSecondary,
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(44.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color(0xFF2B2B3D))
                                        .clickable { showExitConfirmationDialog = false },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("CANCEL", color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(44.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color(0xFFFF1744))
                                        .clickable {
                                            showExitConfirmationDialog = false
                                            onDismiss()
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("EXIT", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            // Redesigned "OUT!" Popup Dialog (0.5s delayed trigger)
            if (isGameOver && showGameOverPopup) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.85f)),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.88f)
                            .clip(RoundedCornerShape(24.dp))
                            .border(1.5.dp, Color(0xFFFF1744).copy(alpha = 0.6f), RoundedCornerShape(24.dp)),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF181824))
                    ) {
                        Column(
                            modifier = Modifier.padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("❌", fontSize = 42.sp)
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "OUT!",
                                color = Color(0xFFFF1744),
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 2.sp
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Score & Level Summary Box
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Color(0xFF0F0F1A))
                                    .padding(horizontal = 16.dp, vertical = 12.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column {
                                    Text("LEVEL REACHED", color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    Text("Level $level", color = NeonGold, fontSize = 16.sp, fontWeight = FontWeight.Black)
                                }
                                Column(horizontalAlignment = Alignment.End) {
                                    Text("TOTAL XP", color = TextSecondary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                                    Text("$score XP", color = Color(0xFF8CE2F3), fontSize = 16.sp, fontWeight = FontWeight.Black)
                                }
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            // TRY AGAIN BUTTON
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(Color(0xFF00E5FF), Color(0xFF00B0FF))
                                        )
                                    )
                                    .clickable {
                                        rows = 3
                                        cols = 3
                                        targetCount = 3
                                        level = 1
                                        score = 0
                                        mistakes = 0
                                        isGameOver = false
                                        hasSavedHistory = false
                                        startNewLevel()
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "TRY AGAIN",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            // SKIP LEVEL BUTTON (With AD badge)
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .background(Color(0xFF242436))
                                    .border(1.dp, Color(0xFF8CE2F3).copy(alpha = 0.3f), RoundedCornerShape(14.dp))
                                    .clickable {
                                        level++
                                        mistakes = 0
                                        isGameOver = false
                                        hasSavedHistory = false
                                        startNewLevel()
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(4.dp))
                                            .background(NeonGold)
                                            .padding(horizontal = 6.dp, vertical = 2.dp)
                                    ) {
                                        Text("AD", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.Black)
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "SKIP LEVEL",
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ReactionGameDialog(
    onDismiss: () -> Unit,
    onGameFinished: (GameHistoryRecord) -> Unit = {},
    initialSubGame: String = "SPEED_REFLEX"
) {
    DisposableEffect(Unit) {
        RelaxingBgmPlayer.startBgm()
        onDispose {
            RelaxingBgmPlayer.stopBgm()
        }
    }

    var selectedSubGame by remember { mutableStateOf(initialSubGame) } // "SPEED_REFLEX" or "ARROW_CLICK"
    var gameState by remember { mutableStateOf(if (initialSubGame == "ARROW_CLICK") "ARROW_CLICK_PLAY" else "READY") } // Direct game start without choose interface
    var round by remember { mutableStateOf(1) }
    val maxRounds = 3
    val reactionTimes = remember { mutableStateListOf<Long>() }
    var startTime by remember { mutableStateOf(0L) }
    var foulCount by remember { mutableStateOf(0) }
    var lastReactionTime by remember { mutableStateOf(0L) }
    var countdownSeconds by remember { mutableStateOf(5) }
    var liveElapsedMillis by remember { mutableStateOf(0L) }
    
    // Arrow Click game state variables
    var arrowAngle by remember { mutableStateOf((0..359).random().toFloat()) }
    var arrowTimerStart by remember { mutableStateOf(System.currentTimeMillis()) }
    var arrowElapsedMillis by remember { mutableStateOf(0L) }
    var arrowLastTime by remember { mutableStateOf(0L) }
    var isShowingFeedback by remember { mutableStateOf(false) }

    // Feedback timer for Arrow Click game (0.5s auto-reset to active gameplay)
    LaunchedEffect(isShowingFeedback) {
        if (isShowingFeedback) {
            delay(500L)
            arrowAngle = (0..359).random().toFloat()
            isShowingFeedback = false
        }
    }

    // Ticking timer for Arrow Click game
    LaunchedEffect(gameState, isShowingFeedback, arrowAngle) {
        if (gameState == "ARROW_CLICK_PLAY" && !isShowingFeedback) {
            val start = System.currentTimeMillis()
            arrowTimerStart = start
            while (gameState == "ARROW_CLICK_PLAY" && !isShowingFeedback) {
                arrowElapsedMillis = System.currentTimeMillis() - start
                delay(10L) // high-precision tick (10ms)
            }
        }
    }
    
    // For adaptive flavor
    var aiMessage by remember { mutableStateOf("🤖 AI Reflection Engine: आपके रिफ्लेक्स का विश्लेषण किया जा रहा है...") }

    // Red Dot Ray Burst state variables
    var targetXRatio by remember { mutableStateOf(0.5f) }
    var targetYRatio by remember { mutableStateOf(0.5f) }
    var targetSpawnTime by remember { mutableStateOf(0L) }
    var hitCount by remember { mutableStateOf(0) }

    // Helper function for random float generation
    fun getRandomFloat(min: Float, max: Float): Float {
        return kotlin.random.Random.nextFloat() * (max - min) + min
    }

    // Trigger 3-second countdown when entering READY phase
    LaunchedEffect(gameState) {
        if (gameState == "READY") {
            countdownSeconds = 3
            while (countdownSeconds > 0) {
                delay(1000L)
                countdownSeconds--
            }
            if (gameState == "READY") {
                hitCount = 0
                reactionTimes.clear()
                targetXRatio = getRandomFloat(0.20f, 0.80f)
                targetYRatio = getRandomFloat(0.25f, 0.75f)
                targetSpawnTime = System.currentTimeMillis()
                gameState = "BURST_TARGET"
            }
        }
    }

    // Live timer ticking when in TAP phase starting from 0.00 seconds
    LaunchedEffect(gameState) {
        if (gameState == "TAP") {
            val start = System.currentTimeMillis()
            startTime = start
            while (gameState == "TAP") {
                liveElapsedMillis = System.currentTimeMillis() - start
                delay(16L) // Update approximately 60 times per second (~16ms)
            }
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            usePlatformDefaultWidth = false,
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if (gameState == "ARROW_CLICK_PLAY") Color.White else Color(0xFF121212))
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(if (gameState == "ARROW_CLICK_PLAY" || gameState == "BURST_TARGET" || gameState == "READY") 0.dp else 24.dp)
        ) {
            // Header for info / exit (unless we are in TAP or READY mode which might occupy the full screen to prevent accidental clicks)
            if (gameState == "START" || gameState == "RESULT" || gameState == "GAMEOVER") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF1E1E1E))
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Exit",
                            tint = TextPrimary,
                            modifier = Modifier.size(18.dp)
                        )
                    }

                    Text(
                        text = "⚡ SPEED REFLEX TEST",
                        color = NeonYellow,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )

                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(NeonYellow.copy(alpha = 0.15f))
                            .border(1.dp, NeonYellow, RoundedCornerShape(8.dp))
                            .padding(horizontal = 10.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = "ROUND $round/$maxRounds",
                            color = NeonYellow,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            // Main Content Area based on gameState
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = if (gameState == "ARROW_CLICK_PLAY" || gameState == "BURST_TARGET" || gameState == "READY") 0.dp else 60.dp),
                contentAlignment = Alignment.Center
            ) {
                when (gameState) {
                    "START" -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState())
                        ) {
                            // Sliding custom tab switcher at the top
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 20.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFF1E1E1E))
                                    .padding(4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(if (selectedSubGame == "SPEED_REFLEX") NeonYellow else Color.Transparent)
                                        .clickable { selectedSubGame = "SPEED_REFLEX" }
                                        .padding(vertical = 10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "Reflex Test",
                                        color = if (selectedSubGame == "SPEED_REFLEX") Color.Black else TextSecondary,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .background(if (selectedSubGame == "ARROW_CLICK") NeonYellow else Color.Transparent)
                                        .clickable { selectedSubGame = "ARROW_CLICK" }
                                        .padding(vertical = 10.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        Text(
                                            text = "Arrow Click",
                                            color = if (selectedSubGame == "ARROW_CLICK") Color.Black else TextSecondary,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(4.dp))
                                                .background(if (selectedSubGame == "ARROW_CLICK") Color.Black else Color(0xFFFF5722))
                                                .padding(horizontal = 4.dp, vertical = 2.dp)
                                        ) {
                                            Text(
                                                text = "NEW",
                                                color = if (selectedSubGame == "ARROW_CLICK") NeonYellow else Color.White,
                                                fontSize = 8.sp,
                                                fontWeight = FontWeight.Black
                                            )
                                        }
                                    }
                                }
                            }

                            // Glowing lightning or arrow target icon based on selected game
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .clip(CircleShape)
                                    .background((if (selectedSubGame == "SPEED_REFLEX") NeonYellow else NeonCyan).copy(alpha = 0.15f))
                                    .border(2.dp, if (selectedSubGame == "SPEED_REFLEX") NeonYellow else NeonCyan, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = if (selectedSubGame == "SPEED_REFLEX") Icons.Default.FlashOn else Icons.Default.TrackChanges,
                                    contentDescription = "Reflex",
                                    tint = if (selectedSubGame == "SPEED_REFLEX") NeonYellow else NeonCyan,
                                    modifier = Modifier.size(54.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))

                            Text(
                                text = if (selectedSubGame == "SPEED_REFLEX") "Speed Reflex Test" else "Arrow Click Test",
                                color = TextPrimary,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = if (selectedSubGame == "SPEED_REFLEX") "Measure your reaction speed and train your reflexes to be lightning fast!" else "Tap the red target tip extending from the black curved arrow as fast as you can!",
                                color = TextSecondary,
                                fontSize = 13.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(horizontal = 24.dp)
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            // Rules Container
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Color(0xFF1A1A1A))
                                    .padding(20.dp),
                                verticalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                if (selectedSubGame == "SPEED_REFLEX") {
                                    Row(verticalAlignment = Alignment.Top) {
                                        Text("🎯", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                                        Text(
                                            text = "1. Tap the START button to begin.",
                                            color = TextSecondary,
                                            fontSize = 13.sp
                                        )
                                    }
                                    Row(verticalAlignment = Alignment.Top) {
                                        Text("⏳", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                                        Text(
                                            text = "2. A 3-second countdown timer will start.",
                                            color = TextSecondary,
                                            fontSize = 13.sp
                                        )
                                    }
                                    Row(verticalAlignment = Alignment.Top) {
                                        Text("💥", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                                        Text(
                                            text = "3. Tap the Red Dot with explosion Ray Bursts as fast as possible!",
                                            color = TextSecondary,
                                            fontSize = 13.sp
                                        )
                                    }
                                } else {
                                    Row(verticalAlignment = Alignment.Top) {
                                        Text("🎯", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                                        Text(
                                            text = "1. Tap the START button to begin.",
                                            color = TextSecondary,
                                            fontSize = 13.sp
                                        )
                                    }
                                    Row(verticalAlignment = Alignment.Top) {
                                        Text("🏹", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                                        Text(
                                            text = "2. A black arrow will appear pointing in a random direction.",
                                            color = TextSecondary,
                                            fontSize = 13.sp
                                        )
                                    }
                                    Row(verticalAlignment = Alignment.Top) {
                                        Text("⚡", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                                        Text(
                                            text = "3. Tap the exact tip (head) of the arrow as fast as possible!",
                                            color = TextSecondary,
                                            fontSize = 13.sp
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            // Start Button
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(54.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            if (selectedSubGame == "SPEED_REFLEX") listOf(NeonYellow, Color(0xFFFF9100)) else listOf(NeonCyan, NeonBlue)
                                        )
                                    )
                                    .clickable {
                                        if (selectedSubGame == "SPEED_REFLEX") {
                                            round = 1
                                            foulCount = 0
                                            reactionTimes.clear()
                                            gameState = "READY"
                                            aiMessage = "🤖 AI Reflection: Focus mode on! Stay ready for green screen."
                                        } else {
                                            arrowAngle = (0..359).random().toFloat()
                                            isShowingFeedback = false
                                            arrowTimerStart = System.currentTimeMillis()
                                            arrowElapsedMillis = 0L
                                            gameState = "ARROW_CLICK_PLAY"
                                        }
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "START GAME",
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }
                    }

                    "READY" -> {
                        // 3-second animated countdown
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(24.dp))
                                .background(
                                    Brush.verticalGradient(
                                        listOf(Color(0xFF1E1010), Color(0xFF0D0808))
                                    )
                                )
                                .border(2.dp, Color(0xFFFF1744), RoundedCornerShape(24.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "3 SECONDS COUNTDOWN",
                                    color = Color(0xFFFF1744),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    letterSpacing = 1.sp
                                )
                                Spacer(modifier = Modifier.height(24.dp))
                                Box(
                                    modifier = Modifier
                                        .size(140.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFFF1744).copy(alpha = 0.15f))
                                        .border(4.dp, Color(0xFFFF1744), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "$countdownSeconds",
                                        color = Color(0xFFFF1744),
                                        fontSize = 64.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                                Spacer(modifier = Modifier.height(28.dp))
                                Text(
                                    text = "GET READY...",
                                    color = Color.White,
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Screen will clear & Red Dot Ray Bursts will appear!",
                                    color = TextSecondary,
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(horizontal = 24.dp)
                                )
                            }
                        }
                    }

                    "BURST_TARGET" -> {
                        val burstTransition = rememberInfiniteTransition(label = "OceanRipplePulse")
                        val pulseProgress by burstTransition.animateFloat(
                            initialValue = 0f,
                            targetValue = 1f,
                            animationSpec = infiniteRepeatable(
                                animation = tween(1200, easing = LinearEasing),
                                repeatMode = RepeatMode.Restart
                            ),
                            label = "ripple"
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFF090B10))
                                .pointerInput(targetXRatio, targetYRatio, gameState) {
                                    detectTapGestures { offset ->
                                        val targetPxX = size.width * targetXRatio
                                        val targetPxY = size.height * targetYRatio
                                        val dx = offset.x - targetPxX
                                        val dy = offset.y - targetPxY
                                        val dist = kotlin.math.sqrt(dx * dx + dy * dy)
                                        if (dist <= 150f) { // Touch target hit zone
                                            val tapTime = System.currentTimeMillis()
                                            val reactionMs = tapTime - targetSpawnTime
                                            lastReactionTime = reactionMs
                                            reactionTimes.add(reactionMs)
                                            hitCount++

                                            // Infinite Mode: Always spawn next target
                                            targetXRatio = getRandomFloat(0.18f, 0.82f)
                                            targetYRatio = getRandomFloat(0.22f, 0.78f)
                                            targetSpawnTime = System.currentTimeMillis()
                                        }
                                    }
                                }
                        ) {
                            // Ocean Water Ripple Wave Canvas (Smooth expanding concentric water rings like dropping a stone in sea/ocean)
                            Canvas(modifier = Modifier.fillMaxSize()) {
                                val centerX = size.width * targetXRatio
                                val centerY = size.height * targetYRatio

                                // 3 Concentric Water Ripple Waves expanding outwards smoothly
                                val rippleRings = 3
                                val maxRadius = 85.dp.toPx()
                                val minRadius = 15.dp.toPx()

                                for (r in 0 until rippleRings) {
                                    val ringPhase = (pulseProgress + r.toFloat() / rippleRings) % 1f
                                    val radius = minRadius + (maxRadius - minRadius) * ringPhase
                                    val alphaVal = (1f - ringPhase).coerceIn(0f, 1f)

                                    // Water ripple outer circle stroke
                                    drawCircle(
                                        color = Color(0xFFFF2A2A).copy(alpha = alphaVal * 0.85f),
                                        radius = radius,
                                        center = Offset(centerX, centerY),
                                        style = Stroke(width = (3.5.dp.toPx() * (1f - ringPhase * 0.5f)))
                                    )
                                }

                                // Soft Glowing Outer Red Aura
                                drawCircle(
                                    color = Color(0xFFFF1744).copy(alpha = 0.20f),
                                    radius = 28.dp.toPx(),
                                    center = Offset(centerX, centerY)
                                )

                                // Vibrant Red Center Target Dot
                                drawCircle(
                                    color = Color(0xFFFF1744),
                                    radius = 21.dp.toPx(),
                                    center = Offset(centerX, centerY)
                                )
                                drawCircle(
                                    color = Color.White,
                                    radius = 7.dp.toPx(),
                                    center = Offset(centerX, centerY)
                                )
                            }

                            // Edge-to-Edge Top Dashboard Bar (Fits device top perfectly)
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.TopCenter)
                            ) {
                                // Top Header Bar with Close Button & Title
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color(0xFF1E293B))
                                        .padding(horizontal = 16.dp, vertical = 12.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(36.dp)
                                            .clip(CircleShape)
                                            .background(Color(0xFF334155))
                                            .clickable { onDismiss() }
                                            .align(Alignment.CenterStart),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = "Close",
                                            tint = Color.White,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }

                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.align(Alignment.Center)
                                    ) {
                                        Text(
                                            text = "REACTION REFLEX",
                                            color = Color(0xFF94A3B8),
                                            fontSize = 11.sp,
                                            fontWeight = FontWeight.Bold,
                                            letterSpacing = 1.sp
                                        )
                                        Text(
                                            text = "RED DOT TARGET",
                                            color = Color.White,
                                            fontSize = 17.sp,
                                            fontWeight = FontWeight.Black,
                                            letterSpacing = 0.5.sp
                                        )
                                    }
                                }

                                // Stats Controls Row
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color(0xFF182232))
                                        .padding(vertical = 10.dp, horizontal = 16.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = "🎯 HITS: ",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = "$hitCount",
                                                color = Color(0xFFFF1744),
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Black
                                            )
                                        }

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = "⚡ SPEED: ",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = if (lastReactionTime > 0) "$lastReactionTime ms" else "READY",
                                                color = NeonCyan,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Black
                                            )
                                        }

                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                text = "📊 AVG: ",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            val avgMs = if (reactionTimes.isNotEmpty()) reactionTimes.average().toInt() else 0
                                            Text(
                                                text = if (avgMs > 0) "$avgMs ms" else "--",
                                                color = NeonYellow,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Black
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }

                    "RESULT" -> {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState())
                        ) {
                            if (lastReactionTime == -1L) {
                                // Foul Result View
                                Box(
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFFF1744).copy(alpha = 0.15f))
                                        .border(2.dp, Color(0xFFFF1744), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🚨", fontSize = 36.sp)
                                }
                                Spacer(modifier = Modifier.height(24.dp))
                                Text(
                                    text = "FOUL!",
                                    color = Color(0xFFFF1744),
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "You tapped before screen turned green!",
                                    color = TextSecondary,
                                    fontSize = 13.sp,
                                    textAlign = TextAlign.Center
                                )
                            } else {
                                // Normal Reaction Time Result View
                                val ratingText = when {
                                    lastReactionTime < 200 -> "🌟 Supersonic Reflexes!"
                                    lastReactionTime < 300 -> "⚡ Lightning Fast!"
                                    lastReactionTime < 450 -> "👍 Great Reflexes!"
                                    else -> "🐢 Needs Practice!"
                                }
                                val ratingColor = when {
                                    lastReactionTime < 200 -> NeonGold
                                    lastReactionTime < 300 -> NeonYellow
                                    lastReactionTime < 450 -> NeonCyan
                                    else -> TextMuted
                                }

                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(CircleShape)
                                        .background(ratingColor.copy(alpha = 0.15f))
                                        .border(2.dp, ratingColor, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Timer,
                                        contentDescription = "Timer",
                                        tint = ratingColor,
                                        modifier = Modifier.size(44.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(24.dp))
                                Text(
                                    text = "$lastReactionTime ms",
                                    color = ratingColor,
                                    fontSize = 36.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = ratingText,
                                    color = ratingColor,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            // Round History
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
                                shape = RoundedCornerShape(16.dp)
                            ) {
                                Column(modifier = Modifier.padding(16.dp)) {
                                    Text(
                                        text = "Rounds History:",
                                        color = TextPrimary,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    (1..round).forEach { rIndex ->
                                        val timeForRound = reactionTimes.getOrNull(rIndex - 1)
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(vertical = 4.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text("Round $rIndex:", color = TextSecondary, fontSize = 12.sp)
                                            if (timeForRound != null) {
                                                Text("$timeForRound ms", color = NeonCyan, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                            } else {
                                                Text("FOUL", color = Color(0xFFFF1744), fontSize = 12.sp, fontWeight = FontWeight.Bold)
                                            }
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            // AI Advice Message Box
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 16.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF161616)),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = aiMessage,
                                        color = Color(0xFF8CE2F3),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }

                            // Next Button
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(54.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(NeonCyan, NeonBlue)
                                        )
                                    )
                                    .clickable {
                                        if (round >= maxRounds) {
                                            gameState = "GAMEOVER"
                                        } else {
                                            round++
                                            gameState = "READY"
                                        }
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = if (round >= maxRounds) "VIEW RESULT" else "NEXT ROUND",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }
                    }

                    "GAMEOVER" -> {
                        // Game Over Summary Screen
                        val validTimes = reactionTimes.filter { it > 0 }
                        val bestTime = if (validTimes.isNotEmpty()) validTimes.minOrNull() ?: 0L else 0L
                        val avgTime = if (validTimes.isNotEmpty()) validTimes.average().toLong() else 0L

                        val starsEarned = when {
                            avgTime > 0 && avgTime < 240 -> 5
                            avgTime > 0 && avgTime < 320 -> 4
                            avgTime > 0 && avgTime < 450 -> 3
                            else -> 2
                        }

                        val xpEarned = when {
                            bestTime > 0 && bestTime < 200 -> 150
                            bestTime > 0 && bestTime < 280 -> 100
                            bestTime > 0 && bestTime < 400 -> 75
                            else -> 40
                        }

                        val titleTag = when {
                            bestTime > 0 && bestTime < 200 -> "GRANDMASTER"
                            bestTime > 0 && bestTime < 280 -> "MASTER"
                            bestTime > 0 && bestTime < 400 -> "EXPERT"
                            else -> "ROOKIE"
                        }

                        // Call save history record exactly once
                        var hasSavedHistory by remember { mutableStateOf(false) }
                        LaunchedEffect(Unit) {
                            if (!hasSavedHistory) {
                                val now = java.util.Calendar.getInstance().time
                                val sdf = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault())
                                val nowFormatted = sdf.format(now)

                                val record = GameHistoryRecord(
                                    gameName = "Reaction Speed Reflex",
                                    score = if (bestTime > 0) bestTime.toInt() else 999,
                                    stars = starsEarned,
                                    titleTag = titleTag,
                                    accuracyText = "Best: ${bestTime}ms / Avg: ${avgTime}ms",
                                    highestStreak = bestTime.toInt(),
                                    timestamp = "Today, $nowFormatted"
                                )
                                onGameFinished(record)
                                hasSavedHistory = true
                            }
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState())
                        ) {
                            Text("⚡", fontSize = 64.sp)
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "GAME OVER!",
                                color = NeonYellow,
                                fontSize = 26.sp,
                                fontWeight = FontWeight.Black
                            )
                            Text(
                                text = "REACTION TEST FINISHED",
                                color = TextSecondary,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.5.sp
                            )

                            Spacer(modifier = Modifier.height(24.dp))

                            // Star Rating Row
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                repeat(5) { i ->
                                    Icon(
                                        imageVector = Icons.Default.Star,
                                        contentDescription = "Star",
                                        tint = if (i < starsEarned) NeonGold else TextMuted,
                                        modifier = Modifier.size(28.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            // Final Stats Card
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xFF1E1E1E))
                                    .padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Best Time:", color = TextSecondary, fontSize = 14.sp)
                                    Text(if (bestTime > 0) "$bestTime ms" else "N/A", color = NeonGold, fontSize = 16.sp, fontWeight = FontWeight.Black)
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Average Time:", color = TextSecondary, fontSize = 14.sp)
                                    Text(if (avgTime > 0) "$avgTime ms" else "N/A", color = NeonYellow, fontSize = 16.sp, fontWeight = FontWeight.Black)
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("XP Earned:", color = TextSecondary, fontSize = 14.sp)
                                    Text("$xpEarned XP", color = NeonCyan, fontSize = 16.sp, fontWeight = FontWeight.Black)
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text("Fouls:", color = TextSecondary, fontSize = 14.sp)
                                    Text("$foulCount", color = Color(0xFFFF1744), fontSize = 16.sp, fontWeight = FontWeight.Bold)
                                }
                            }

                            Spacer(modifier = Modifier.height(32.dp))

                            // Play Again Button (Neon gradient)
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(54.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(
                                        Brush.horizontalGradient(
                                            listOf(NeonYellow, Color(0xFFFF9100))
                                        )
                                    )
                                    .clickable {
                                        round = 1
                                        foulCount = 0
                                        reactionTimes.clear()
                                        if (selectedSubGame == "ARROW_CLICK") {
                                            arrowAngle = (0..359).random().toFloat()
                                            isShowingFeedback = false
                                            arrowTimerStart = System.currentTimeMillis()
                                            arrowElapsedMillis = 0L
                                            gameState = "ARROW_CLICK_PLAY"
                                        } else {
                                            gameState = "READY"
                                        }
                                        aiMessage = "🤖 AI Reflection Engine: Try again! Aim for faster reaction time."
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "PLAY AGAIN",
                                    color = Color.Black,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Quit Button
                            Box(
                                modifier = Modifier
                                    .clickable { onDismiss() }
                                    .padding(horizontal = 16.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = "EXIT",
                                    color = TextMuted,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }

                    "ARROW_CLICK_PLAY" -> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                        ) {
                            // Header showing the custom ticking timer at the top (Overlaid)
                            val timerSecStr = String.format(java.util.Locale.US, "%.2f", arrowElapsedMillis / 1000.0)
                            
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.TopCenter)
                                    .padding(horizontal = 20.dp, vertical = 24.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                // Exit Button to return to START screen
                                IconButton(
                                    onClick = { gameState = "START" },
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(CircleShape)
                                        .background(Color(0xFFEEEEEE))
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Back to Menu",
                                        tint = Color.Black,
                                        modifier = Modifier.size(20.dp)
                                    )
                                }

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "REACTION TIME",
                                        color = Color(0xFF555555),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp
                                    )
                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "${timerSecStr}s",
                                        color = Color.Black,
                                        fontSize = 32.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "$arrowElapsedMillis ms",
                                        color = Color(0xFF777777),
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "TAP THE ARROW TIP!",
                                        color = Color.Black,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                // Just a spacer placeholder to align correctly
                                Spacer(modifier = Modifier.width(44.dp))
                            }

                            if (isShowingFeedback) {
                                // Feedback Screen shown in the center for 0.5s after tapping tip
                                Column(
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(horizontal = 24.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "Success",
                                        tint = Color(0xFF2E7D32),
                                        modifier = Modifier.size(80.dp)
                                    )
                                    Spacer(modifier = Modifier.height(16.dp))
                                    Text(
                                        text = "TAPPED!",
                                        color = Color.Black,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = "$arrowLastTime ms",
                                        color = Color(0xFF1B5E20),
                                        fontSize = 36.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        text = when {
                                            arrowLastTime < 250 -> "⚡ Supersonic Reflexes!"
                                            arrowLastTime < 450 -> "⚡ Lightning Fast!"
                                            else -> "👍 Great Job!"
                                        },
                                        color = Color(0xFF555555),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            } else {
                                // Active gameplay: Canvas that takes the whole screen with arrow pointing in a random angle
                                Canvas(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .pointerInput(arrowAngle) {
                                            detectTapGestures { offset ->
                                                val centerX = size.width / 2f
                                                val centerY = size.height / 2f
                                                val maxDimension = minOf(size.width, size.height)
                                                val halfLength = maxDimension * 0.36f
                                                val angleRad = Math.toRadians(arrowAngle.toDouble())
                                                
                                                val tipX = centerX + halfLength * Math.cos(angleRad).toFloat()
                                                val tipY = centerY + halfLength * Math.sin(angleRad).toFloat()
                                                
                                                val dx = offset.x - tipX
                                                val dy = offset.y - tipY
                                                val distance = Math.sqrt((dx * dx + dy * dy).toDouble())
                                                
                                                val tapRadiusPx = 60.dp.toPx()
                                                if (distance <= tapRadiusPx) {
                                                    arrowLastTime = System.currentTimeMillis() - arrowTimerStart
                                                    isShowingFeedback = true
                                                }
                                            }
                                        }
                                ) {
                                    val centerX = size.width / 2f
                                    val centerY = size.height / 2f
                                    val maxDimension = minOf(size.width, size.height)
                                    
                                    val halfLength = maxDimension * 0.36f
                                    val angleRad = Math.toRadians(arrowAngle.toDouble())
                                    val strokeWidthPx = 32f
                                    val headSize = maxDimension * 0.18f
                                    
                                    val tailX = centerX - halfLength * Math.cos(angleRad).toFloat()
                                    val tailY = centerY - halfLength * Math.sin(angleRad).toFloat()
                                    val tipX = centerX + halfLength * Math.cos(angleRad).toFloat()
                                    val tipY = centerY + halfLength * Math.sin(angleRad).toFloat()
                                    
                                    // 1. Shaft (straight black line with rounded cap at tail)
                                    drawLine(
                                        color = Color.Black,
                                        start = Offset(tailX, tailY),
                                        end = Offset(tipX, tipY),
                                        strokeWidth = strokeWidthPx,
                                        cap = StrokeCap.Round
                                    )
                                    
                                    // 2. Chevron Wing 1
                                    val wing1Angle = angleRad + Math.toRadians(135.0)
                                    val wing1X = tipX + headSize * Math.cos(wing1Angle).toFloat()
                                    val wing1Y = tipY + headSize * Math.sin(wing1Angle).toFloat()
                                    drawLine(
                                        color = Color.Black,
                                        start = Offset(tipX, tipY),
                                        end = Offset(wing1X, wing1Y),
                                        strokeWidth = strokeWidthPx,
                                        cap = StrokeCap.Round
                                    )
                                    
                                    // 3. Chevron Wing 2
                                    val wing2Angle = angleRad - Math.toRadians(135.0)
                                    val wing2X = tipX + headSize * Math.cos(wing2Angle).toFloat()
                                    val wing2Y = tipY + headSize * Math.sin(wing2Angle).toFloat()
                                    drawLine(
                                        color = Color.Black,
                                        start = Offset(tipX, tipY),
                                        end = Offset(wing2X, wing2Y),
                                        strokeWidth = strokeWidthPx,
                                        cap = StrokeCap.Round
                                    )
                                    
                                    // 4. Red Dot at Arrow Tip (Visual Indicator)
                                    drawCircle(
                                        color = Color(0xFFFF1744),
                                        center = Offset(tipX, tipY),
                                        radius = 12f
                                    )
                                    drawCircle(
                                        color = Color.White,
                                        center = Offset(tipX, tipY),
                                        radius = 5f
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileTabScreen(
    userName: String,
    userBio: String,
    userEmoji: String,
    onSaveProfile: (String, String, String) -> Unit,
    onPlayMathGame: () -> Unit,
    onOpenSettings: () -> Unit,
    gameHistory: List<GameHistoryRecord>
) {
    val context = LocalContext.current
    var showEditDialog by remember { mutableStateOf(false) }

    if (showEditDialog) {
        EditProfileModalDialog(
            currentName = userName,
            currentBio = userBio,
            currentEmoji = userEmoji,
            onDismiss = { showEditDialog = false },
            onSave = { newName, newBio, newEmoji ->
                onSaveProfile(newName, newBio, newEmoji)
                showEditDialog = false
                Toast.makeText(context, "Profile updated and saved permanently! 🚀", Toast.LENGTH_SHORT).show()
            }
        )
    }

    // Real Career Stats Calculations from actual Game History
    val totalMatches = gameHistory.size
    val totalBrainXp = gameHistory.sumOf { it.score }
    val avgAccuracy = if (gameHistory.isNotEmpty()) {
        val accList = gameHistory.mapNotNull { it.accuracyText.replace("%", "").trim().toIntOrNull() }
        if (accList.isNotEmpty()) "${accList.average().toInt()}%" else "100%"
    } else "0%"
    val maxStreak = gameHistory.maxOfOrNull { it.highestStreak }?.let { "$it Days" } ?: "0 Days"

    // 5,000 XP per level design, max 100 levels (500,000 XP total)
    val xpPerLevel = 5000
    val currentMindLevel = (1 + (totalBrainXp / xpPerLevel)).coerceAtMost(100)
    val currentLevelXpProgress = if (currentMindLevel >= 100) xpPerLevel else (totalBrainXp % xpPerLevel)
    val levelProgressFraction = (currentLevelXpProgress.toFloat() / xpPerLevel.toFloat()).coerceIn(0.02f, 1f)
    val xpNeededForNextLevel = if (currentMindLevel >= 100) 0 else (xpPerLevel - currentLevelXpProgress)

    val battleRecords = gameHistory.filter {
        it.gameName.contains("Battle", ignoreCase = true) || it.gameName.contains("2-Player", ignoreCase = true)
    }
    val battleMatches = battleRecords.size
    val battleWins = battleRecords.count { it.score > 0 || it.titleTag.contains("WIN", ignoreCase = true) }
    val winRateStr = if (battleMatches > 0) "${(battleWins * 100 / battleMatches)}% WIN RATE" else "0% WIN RATE"
    val bestScoreStr = gameHistory.maxOfOrNull { it.score }?.let { "$it Pts" } ?: "0 Pts"

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // 1. Profile Header Card (Grandmaster badge removed)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 1.dp,
                    color = CyberCardBorder,
                    shape = RoundedCornerShape(16.dp)
                )
                .testTag("profile_header_card"),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Profile Avatar with Glowing Ring
                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .background(
                                Brush.linearGradient(
                                    listOf(NeonCyan, NeonBlue)
                                )
                            )
                            .clickable { showEditDialog = true }
                            .padding(2.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(CircleShape)
                                .background(CyberSurface),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(userEmoji, fontSize = 28.sp)
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    // Name & Bio (No Grandmaster badge)
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = userName,
                            color = TextPrimary,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Black,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(2.dp))

                        Text(
                            text = userBio,
                            color = TextSecondary,
                            fontSize = 11.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Edit Profile & Settings Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(CyberSurfaceVariant)
                            .border(1.dp, NeonCyan, RoundedCornerShape(10.dp))
                            .clickable { showEditDialog = true }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "Edit Profile",
                                tint = NeonCyan,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "EDIT PROFILE",
                                color = NeonCyan,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(10.dp))
                            .background(CyberSurfaceVariant)
                            .border(1.dp, CyberCardBorder, RoundedCornerShape(10.dp))
                            .clickable { onOpenSettings() }
                            .padding(vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "Settings",
                                tint = TextPrimary,
                                modifier = Modifier.size(13.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "SETTINGS",
                                color = TextPrimary,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // 2. Level & XP Fill Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, CyberCardBorder, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("🚀", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "MIND LEVEL $currentMindLevel",
                            color = NeonGreen,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Black
                        )
                    }
                    Text(
                        text = "$currentLevelXpProgress / 5,000 XP (Total $totalBrainXp XP)",
                        color = TextMuted,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                LinearProgressIndicator(
                    progress = { levelProgressFraction },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(8.dp)
                        .clip(RoundedCornerShape(4.dp)),
                    color = NeonGreen,
                    trackColor = CyberSurfaceVariant
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = if (currentMindLevel >= 100) "🏆 Max Rank Reached (Level 100 • 500,000 XP)" else "🏆 Level $currentMindLevel / 100 • $xpNeededForNextLevel XP needed for Level ${currentMindLevel + 1} (5k XP / Lvl)",
                    color = TextSecondary,
                    fontSize = 10.sp
                )
            }
        }

        // 3. Career Stats Grid (100% Real Data from gameHistory)
        Text(
            text = "PLAYER CAREER STATS",
            color = TextPrimary,
            fontSize = 13.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.5.sp
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(CyberSurfaceVariant)
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(12.dp))
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🎮 MATCHES", color = TextMuted, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text("$totalMatches", color = NeonCyan, fontSize = 16.sp, fontWeight = FontWeight.Black)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(CyberSurfaceVariant)
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(12.dp))
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🏆 BRAIN XP", color = TextMuted, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text("$totalBrainXp", color = NeonGold, fontSize = 16.sp, fontWeight = FontWeight.Black)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(CyberSurfaceVariant)
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(12.dp))
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🎯 ACCURACY", color = TextMuted, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(avgAccuracy, color = NeonPurpleBright, fontSize = 16.sp, fontWeight = FontWeight.Black)
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(12.dp))
                    .background(CyberSurfaceVariant)
                    .border(1.dp, CyberCardBorder, RoundedCornerShape(12.dp))
                    .padding(10.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("🔥 STREAK", color = TextMuted, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(maxStreak, color = Color(0xFFFF7A00), fontSize = 15.sp, fontWeight = FontWeight.Black)
                }
            }
        }

        // 4. Battle Arena Summary Card (Real Data)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, CyberCardBorder, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("⚔️", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "BATTLE ARENA RECORD",
                            color = NeonCyan,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 0.5.sp
                        )
                    }
                    Text(winRateStr, color = NeonYellow, fontSize = 10.sp, fontWeight = FontWeight.Black)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(CyberSurfaceVariant)
                            .padding(8.dp)
                    ) {
                        Column {
                            Text("Battles Played", color = TextMuted, fontSize = 9.sp)
                            Text("$battleMatches Matches", color = TextPrimary, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(CyberSurfaceVariant)
                            .padding(8.dp)
                    ) {
                        Column {
                            Text("Victories", color = TextMuted, fontSize = 9.sp)
                            Text("$battleWins Wins 🥇", color = NeonGreen, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .background(CyberSurfaceVariant)
                            .padding(8.dp)
                    ) {
                        Column {
                            Text("Best Highscore", color = TextMuted, fontSize = 9.sp)
                            Text(bestScoreStr, color = NeonGold, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        // 5. Global XP Leaderboard Section
        XpLeaderboardCard(currentUserName = userName, currentUserEmoji = userEmoji)

        // 6. Share & Challenge Card (Placed BELOW Leaderboard Card at the VERY BOTTOM)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .border(1.dp, CyberCardBorder, RoundedCornerShape(16.dp)),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "📢 CHALLENGE FRIENDS",
                        color = NeonYellow,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        text = "Share your profile stats ($totalBrainXp XP) with friends!",
                        color = TextSecondary,
                        fontSize = 10.sp
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(NeonGreen)
                        .clickable {
                            Toast.makeText(context, "Profile Stats Copied to Clipboard! 🚀", Toast.LENGTH_SHORT).show()
                        }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "SHARE STATS",
                        color = Color.Black,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }
    }
}

@Composable
fun EditProfileModalDialog(
    currentName: String,
    currentBio: String,
    currentEmoji: String,
    onDismiss: () -> Unit,
    onSave: (String, String, String) -> Unit
) {
    var name by remember { mutableStateOf(currentName) }
    var bio by remember { mutableStateOf(currentBio) }
    var selectedEmoji by remember { mutableStateOf(currentEmoji) }

    val emojiOptions = listOf("👑", "⚡", "🧠", "🦁", "🚀", "🎮", "🎯", "🏆", "💎", "🐉")

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .clip(RoundedCornerShape(20.dp))
                .border(1.dp, CyberCardBorder, RoundedCornerShape(20.dp)),
            colors = CardDefaults.cardColors(containerColor = CyberSurface)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "EDIT PLAYER PROFILE",
                        color = NeonCyan,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Black
                    )
                    IconButton(
                        onClick = onDismiss,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = TextMuted)
                    }
                }

                HorizontalDivider(color = CyberCardBorder)

                // Select Avatar Emoji
                Text(
                    text = "CHOOSE AVATAR EMOJI",
                    color = NeonGold,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    emojiOptions.forEach { emo ->
                        val isSel = selectedEmoji == emo
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(CyberSurfaceVariant)
                                .border(1.5.dp, if (isSel) NeonCyan else Color.Transparent, CircleShape)
                                .clickable { selectedEmoji = emo },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(emo, fontSize = 20.sp)
                        }
                    }
                }

                // Name Input
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Display Name", fontSize = 10.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = CyberCardBorder,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    )
                )

                // Bio Input
                OutlinedTextField(
                    value = bio,
                    onValueChange = { bio = it },
                    label = { Text("Bio / Status", fontSize = 10.sp) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = NeonCyan,
                        unfocusedBorderColor = CyberCardBorder,
                        focusedTextColor = TextPrimary,
                        unfocusedTextColor = TextPrimary
                    )
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Save Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(NeonGreen)
                        .clickable { onSave(name, bio, selectedEmoji) }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "SAVE PROFILE CHANGES",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }
    }
}



data class OneLinePoint(val x: Float, val y: Float)

data class OneLineEdge(val u: Int, val v: Int) {
    fun matches(a: Int, b: Int): Boolean = (u == a && v == b) || (u == b && v == a)
}

data class OneLinePuzzleLevel(
    val levelNumber: Int,
    val nodes: List<OneLinePoint>,
    val edges: List<OneLineEdge>,
    val solutionPath: List<Int>,
    val packName: String,
    val themeDotColor: Color
)

object OneLinePuzzleGenerator {
    private val themeColors = listOf(
        Color(0xFF9C27B0), // Purple
        Color(0xFFE91E63), // Pink
        Color(0xFF00ACC1), // Cyan
        Color(0xFF43A047), // Green
        Color(0xFFFB8C00), // Orange
        Color(0xFF1E88E5)  // Blue
    )

    private fun isNodeBetween(a: OneLinePoint, b: OneLinePoint, c: OneLinePoint): Boolean {
        val dx = b.x - a.x
        val dy = b.y - a.y
        val lenSq = dx * dx + dy * dy
        if (lenSq < 0.0001f) return false
        val t = ((c.x - a.x) * dx + (c.y - a.y) * dy) / lenSq
        if (t <= 0.05f || t >= 0.95f) return false
        val projX = a.x + t * dx
        val projY = a.y + t * dy
        val distSq = (c.x - projX) * (c.x - projX) + (c.y - projY) * (c.y - projY)
        return distSq < 0.0064f
    }

    fun generateLevel(levelSeed: Int): OneLinePuzzleLevel {
        val random = java.util.Random(levelSeed.toLong() * 9973L + 12345L)
        val packIndex = (levelSeed - 1) / 20 + 1
        val packName = "PACK $packIndex"
        val themeColor = themeColors[(packIndex - 1) % themeColors.size]

        val targetNodeCount = when {
            levelSeed == 1 -> 3
            levelSeed <= 3 -> 4
            levelSeed <= 6 -> 5
            levelSeed <= 10 -> 6
            levelSeed <= 16 -> 7
            levelSeed <= 25 -> 8
            levelSeed <= 35 -> 9
            else -> (10 + (levelSeed - 35) / 5).coerceAtMost(14)
        }

        val targetEdges = when {
            levelSeed == 1 -> 3
            levelSeed == 2 -> 4
            levelSeed == 3 -> 5
            levelSeed <= 5 -> 6
            levelSeed <= 8 -> 8
            levelSeed <= 12 -> 10
            levelSeed <= 18 -> 13
            levelSeed <= 25 -> 17
            else -> (18 + (levelSeed - 25) * 3 / 4).coerceAtMost(28)
        }

        val nodes = generateNodeLayout(targetNodeCount, levelSeed, random)
        val numNodes = nodes.size

        val path = mutableListOf<Int>()
        val edgeSet = mutableSetOf<Pair<Int, Int>>()

        var curr = random.nextInt(numNodes)
        path.add(curr)

        var attempts = 0
        while (edgeSet.size < targetEdges && attempts < 800) {
            attempts++
            val candidates = mutableListOf<Int>()
            for (next in 0 until numNodes) {
                if (next == curr) continue
                val u = kotlin.math.min(curr, next)
                val v = kotlin.math.max(curr, next)
                if (!edgeSet.contains(u to v)) {
                    val dx = nodes[curr].x - nodes[next].x
                    val dy = nodes[curr].y - nodes[next].y
                    val distSq = dx * dx + dy * dy
                    if (distSq < 0.70f) {
                        val hasIntermediateNode = (0 until numNodes).any { k ->
                            k != curr && k != next && isNodeBetween(nodes[curr], nodes[next], nodes[k])
                        }
                        if (!hasIntermediateNode) {
                            candidates.add(next)
                        }
                    }
                }
            }

            if (candidates.isNotEmpty()) {
                val next = candidates[random.nextInt(candidates.size)]
                val u = kotlin.math.min(curr, next)
                val v = kotlin.math.max(curr, next)
                edgeSet.add(u to v)
                path.add(next)
                curr = next
            } else {
                if (edgeSet.size >= kotlin.math.min(targetEdges, 3)) {
                    break
                } else {
                    edgeSet.clear()
                    path.clear()
                    curr = random.nextInt(numNodes)
                    path.add(curr)
                }
            }
        }

        val edgesList = edgeSet.map { OneLineEdge(it.first, it.second) }

        return OneLinePuzzleLevel(
            levelNumber = levelSeed,
            nodes = nodes,
            edges = edgesList,
            solutionPath = path,
            packName = packName,
            themeDotColor = themeColor
        )
    }

    private fun generateNodeLayout(nodeCount: Int, levelSeed: Int, random: java.util.Random): List<OneLinePoint> {
        val patternType = (levelSeed + random.nextInt(5)) % 7
        val pts = mutableListOf<OneLinePoint>()

        when (patternType) {
            0 -> { // HOUSE / ENVELOPE SHAPE
                pts.add(OneLinePoint(0.2f, 0.8f))
                pts.add(OneLinePoint(0.8f, 0.8f))
                pts.add(OneLinePoint(0.2f, 0.45f))
                pts.add(OneLinePoint(0.8f, 0.45f))
                pts.add(OneLinePoint(0.5f, 0.18f))
                if (nodeCount >= 6) pts.add(OneLinePoint(0.5f, 0.625f))
                if (nodeCount >= 7) pts.add(OneLinePoint(0.5f, 0.8f))
                if (nodeCount >= 8) pts.add(OneLinePoint(0.2f, 0.25f))
                if (nodeCount >= 9) pts.add(OneLinePoint(0.8f, 0.25f))
            }
            1 -> { // 5-POINT STAR / PENTAGRAM
                val cx = 0.5f
                val cy = 0.5f
                val r = 0.38f
                for (i in 0 until 5) {
                    val angle = Math.toRadians((i * 72 - 90).toDouble())
                    pts.add(OneLinePoint(cx + (r * Math.cos(angle)).toFloat(), cy + (r * Math.sin(angle)).toFloat()))
                }
                if (nodeCount >= 6) pts.add(OneLinePoint(cx, cy))
                val rInner = 0.18f
                for (i in 0 until (nodeCount - 6).coerceAtMost(5)) {
                    val angle = Math.toRadians((i * 72 - 54).toDouble())
                    pts.add(OneLinePoint(cx + (rInner * Math.cos(angle)).toFloat(), cy + (rInner * Math.sin(angle)).toFloat()))
                }
            }
            2 -> { // 3D CUBE WIREFRAME
                pts.add(OneLinePoint(0.18f, 0.35f))
                pts.add(OneLinePoint(0.62f, 0.35f))
                pts.add(OneLinePoint(0.18f, 0.82f))
                pts.add(OneLinePoint(0.62f, 0.82f))

                pts.add(OneLinePoint(0.38f, 0.18f))
                pts.add(OneLinePoint(0.82f, 0.18f))
                pts.add(OneLinePoint(0.38f, 0.65f))
                pts.add(OneLinePoint(0.82f, 0.65f))

                if (nodeCount >= 9) pts.add(OneLinePoint(0.5f, 0.5f))
            }
            3 -> { // HOURGLASS FISH
                pts.add(OneLinePoint(0.5f, 0.15f))
                pts.add(OneLinePoint(0.18f, 0.4f))
                pts.add(OneLinePoint(0.82f, 0.4f))
                pts.add(OneLinePoint(0.5f, 0.5f))
                pts.add(OneLinePoint(0.18f, 0.85f))
                pts.add(OneLinePoint(0.82f, 0.85f))
                pts.add(OneLinePoint(0.5f, 0.85f))
                if (nodeCount >= 8) pts.add(OneLinePoint(0.5f, 0.32f))
            }
            4 -> { // CROWN LATTICE
                pts.add(OneLinePoint(0.18f, 0.8f))
                pts.add(OneLinePoint(0.82f, 0.8f))
                pts.add(OneLinePoint(0.18f, 0.35f))
                pts.add(OneLinePoint(0.5f, 0.18f))
                pts.add(OneLinePoint(0.82f, 0.35f))
                pts.add(OneLinePoint(0.34f, 0.55f))
                pts.add(OneLinePoint(0.66f, 0.55f))
                pts.add(OneLinePoint(0.5f, 0.8f))
            }
            5 -> { // HEXAGON RING WITH CENTER
                val cx = 0.5f
                val cy = 0.5f
                val r = 0.36f
                for (i in 0 until 6) {
                    val angle = Math.toRadians((i * 60).toDouble())
                    pts.add(OneLinePoint(cx + (r * Math.cos(angle)).toFloat(), cy + (r * Math.sin(angle)).toFloat()))
                }
                pts.add(OneLinePoint(cx, cy))
                if (nodeCount >= 8) pts.add(OneLinePoint(0.5f, 0.2f))
                if (nodeCount >= 9) pts.add(OneLinePoint(0.5f, 0.8f))
            }
            else -> { // GRID MATRIX
                val rows = if (nodeCount > 9) 4 else 3
                val cols = 3
                for (r in 0 until rows) {
                    for (c in 0 until cols) {
                        val x = 0.2f + c * 0.3f
                        val y = 0.2f + r * 0.2f
                        pts.add(OneLinePoint(x, y))
                    }
                }
            }
        }

        while (pts.size < nodeCount) {
            val i1 = random.nextInt(pts.size)
            val i2 = random.nextInt(pts.size)
            if (i1 != i2) {
                val mx = (pts[i1].x + pts[i2].x) / 2f
                val my = (pts[i1].y + pts[i2].y) / 2f
                if (pts.none { Math.hypot((it.x - mx).toDouble(), (it.y - my).toDouble()) < 0.1 }) {
                    pts.add(OneLinePoint(mx, my))
                }
            }
            if (pts.size < nodeCount && random.nextFloat() < 0.3f) {
                val rx = 0.18f + random.nextFloat() * 0.64f
                val ry = 0.18f + random.nextFloat() * 0.64f
                pts.add(OneLinePoint(rx, ry))
            }
        }

        val selectedPts = pts.take(nodeCount)
        if (selectedPts.isEmpty()) return selectedPts

        val minX = selectedPts.minOf { it.x }
        val maxX = selectedPts.maxOf { it.x }
        val minY = selectedPts.minOf { it.y }
        val maxY = selectedPts.maxOf { it.y }

        val centerX = (minX + maxX) / 2f
        val centerY = (minY + maxY) / 2f
        val width = maxX - minX
        val height = maxY - minY

        val maxDim = maxOf(width, height)
        val targetSize = 0.62f
        val scale = if (maxDim > 0.001f) (targetSize / maxDim).coerceAtMost(1.1f) else 1f

        return selectedPts.map { p ->
            val nx = 0.5f + (p.x - centerX) * scale
            val ny = 0.5f + (p.y - centerY) * scale
            OneLinePoint(nx.coerceIn(0.12f, 0.88f), ny.coerceIn(0.12f, 0.88f))
        }
    }
}

@Composable
fun DotConnectGameDialog(
    onDismiss: () -> Unit,
    onGameFinished: (GameHistoryRecord) -> Unit = {}
) {
    DisposableEffect(Unit) {
        RelaxingBgmPlayer.startBgm()
        onDispose {
            RelaxingBgmPlayer.stopBgm()
        }
    }

    var levelNumber by remember { mutableIntStateOf(1) }

    var currentLevel by remember { mutableStateOf(OneLinePuzzleGenerator.generateLevel(1)) }

    val userPath = remember { mutableStateListOf<Int>() }
    val userTraversedEdgePairs = remember { mutableStateListOf<Pair<Int, Int>>() }

    var dragTouchOffset by remember { mutableStateOf<Offset?>(null) }
    var isLevelCleared by remember { mutableStateOf(false) }
    var hintEdge by remember { mutableStateOf<Pair<Int, Int>?>(null) }

    fun loadLevel(lvl: Int) {
        levelNumber = lvl.coerceAtLeast(1)
        currentLevel = OneLinePuzzleGenerator.generateLevel(levelNumber)
        userPath.clear()
        userTraversedEdgePairs.clear()
        dragTouchOffset = null
        isLevelCleared = false
        hintEdge = null
    }

    LaunchedEffect(levelNumber) {
        loadLevel(levelNumber)
    }

    LaunchedEffect(userTraversedEdgePairs.size) {
        if (userTraversedEdgePairs.isNotEmpty() && currentLevel.edges.isNotEmpty()) {
            val allCovered = currentLevel.edges.all { edge ->
                val pair = kotlin.math.min(edge.u, edge.v) to kotlin.math.max(edge.u, edge.v)
                userTraversedEdgePairs.contains(pair)
            }
            if (allCovered && !isLevelCleared) {
                isLevelCleared = true
                val nowFormatted = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
                onGameFinished(
                    GameHistoryRecord(
                        id = System.currentTimeMillis().toString(),
                        gameName = "Dot Connect Level $levelNumber",
                        score = levelNumber * 100,
                        stars = 3,
                        titleTag = "🔴 ONE LINE MASTER",
                        accuracyText = "100% Solved",
                        highestStreak = levelNumber,
                        timestamp = "Today, $nowFormatted"
                    )
                )
            }
        }
    }

    fun isEdgeInLevel(u: Int, v: Int): Boolean {
        return currentLevel.edges.any { it.matches(u, v) }
    }

    fun isEdgeTraversed(u: Int, v: Int): Boolean {
        val pair1 = kotlin.math.min(u, v) to kotlin.math.max(u, v)
        return userTraversedEdgePairs.contains(pair1)
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp),
            color = Color(0xFF0F172A) // Sleek Dark Slate Canvas
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.safeDrawing)
            ) {
                // Top Main Bar (Dark Header with Title & Close)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF1E293B))
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    // Close Button Left
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF334155))
                            .clickable { onDismiss() }
                            .align(Alignment.CenterStart),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    // Level Title Center
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(
                            text = "PACK ${(levelNumber - 1) / 20 + 1}",
                            color = Color(0xFF94A3B8),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = "LEVEL $levelNumber",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            letterSpacing = 0.5.sp
                        )
                    }
                }

                // Top Options / Controls Bar (UNDO, RESET, HINT, PREV, NEXT)
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF182232))
                        .padding(vertical = 10.dp, horizontal = 12.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Prev Level
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF26334D))
                                .clickable { if (levelNumber > 1) loadLevel(levelNumber - 1) }
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Prev",
                                tint = if (levelNumber > 1) Color.White else Color.Gray,
                                modifier = Modifier.size(16.dp)
                            )
                        }

                        // Undo Button
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF26334D))
                                .clickable {
                                    if (userPath.isNotEmpty() && !isLevelCleared) {
                                        val removed = userPath.removeAt(userPath.size - 1)
                                        if (userPath.isNotEmpty()) {
                                            val prev = userPath.last()
                                            val pairToRemove = kotlin.math.min(removed, prev) to kotlin.math.max(removed, prev)
                                            userTraversedEdgePairs.remove(pairToRemove)
                                        }
                                    }
                                }
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Undo",
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("UNDO", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }

                        // Reset Button
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF26334D))
                                .clickable {
                                    userPath.clear()
                                    userTraversedEdgePairs.clear()
                                    isLevelCleared = false
                                    hintEdge = null
                                }
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Refresh,
                                contentDescription = "Reset",
                                tint = Color(0xFFF43F5E),
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("RESET", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }

                        // Hint Button
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF26334D))
                                .clickable {
                                    if (!isLevelCleared) {
                                        val sol = currentLevel.solutionPath
                                        for (i in 0 until sol.size - 1) {
                                            val u = sol[i]
                                            val v = sol[i + 1]
                                            val pair = kotlin.math.min(u, v) to kotlin.math.max(u, v)
                                            if (!userTraversedEdgePairs.contains(pair)) {
                                                hintEdge = pair
                                                break
                                            }
                                        }
                                    }
                                }
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("💡", fontSize = 14.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("HINT", color = Color(0xFFFFD600), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }

                        // Next Level
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color(0xFF26334D))
                                .clickable { loadLevel(levelNumber + 1) }
                                .padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowForward,
                                contentDescription = "Next",
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                }

                // Dark Puzzle Canvas Container
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(Color(0xFF0F172A))
                        .pointerInput(currentLevel, isLevelCleared) {
                            if (isLevelCleared) return@pointerInput

                            val w = size.width.toFloat()
                            val h = size.height.toFloat()

                            fun getClosestNodeIndex(touchPos: Offset): Int? {
                                val nodeRadiusPx = w * 0.12f
                                for (i in currentLevel.nodes.indices) {
                                    val nx = currentLevel.nodes[i].x * w
                                    val ny = currentLevel.nodes[i].y * h
                                    val dist = Math.hypot((touchPos.x - nx).toDouble(), (touchPos.y - ny).toDouble()).toFloat()
                                    if (dist <= nodeRadiusPx) {
                                        return i
                                    }
                                }
                                return null
                            }

                            detectDragGestures(
                                onDragStart = { startPos ->
                                    val idx = getClosestNodeIndex(startPos)
                                    if (idx != null && userPath.isEmpty()) {
                                        userPath.add(idx)
                                    }
                                    dragTouchOffset = startPos
                                },
                                onDrag = { change, _ ->
                                    dragTouchOffset = change.position
                                    val closest = getClosestNodeIndex(change.position)
                                    if (closest != null && userPath.isNotEmpty()) {
                                        val lastNode = userPath.last()
                                        if (closest != lastNode) {
                                            if (userPath.size >= 2 && userPath[userPath.size - 2] == closest) {
                                                // Undo last step
                                                val removed = userPath.removeAt(userPath.size - 1)
                                                val pairToRemove = kotlin.math.min(removed, closest) to kotlin.math.max(removed, closest)
                                                userTraversedEdgePairs.remove(pairToRemove)
                                            } else if (isEdgeInLevel(lastNode, closest) && !isEdgeTraversed(lastNode, closest)) {
                                                userPath.add(closest)
                                                val pairToAdd = kotlin.math.min(lastNode, closest) to kotlin.math.max(lastNode, closest)
                                                userTraversedEdgePairs.add(pairToAdd)

                                                if (userTraversedEdgePairs.size == currentLevel.edges.size) {
                                                    isLevelCleared = true
                                                    val nowFormatted = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
                                                    onGameFinished(
                                                        GameHistoryRecord(
                                                            id = System.currentTimeMillis().toString(),
                                                            gameName = "Dot Connect Level $levelNumber",
                                                            score = levelNumber * 100,
                                                            stars = 3,
                                                            titleTag = "🔴 ONE LINE MASTER",
                                                            accuracyText = "100% Solved",
                                                            highestStreak = levelNumber,
                                                            timestamp = "Today, $nowFormatted"
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                },
                                onDragEnd = { dragTouchOffset = null },
                                onDragCancel = { dragTouchOffset = null }
                            )
                        }
                        .pointerInput(currentLevel, isLevelCleared) {
                            if (isLevelCleared) return@pointerInput

                            val w = size.width.toFloat()
                            val h = size.height.toFloat()

                            detectTapGestures { tapPos ->
                                val nodeRadiusPx = w * 0.12f
                                var tappedIdx: Int? = null
                                for (i in currentLevel.nodes.indices) {
                                    val nx = currentLevel.nodes[i].x * w
                                    val ny = currentLevel.nodes[i].y * h
                                    val dist = Math.hypot((tapPos.x - nx).toDouble(), (tapPos.y - ny).toDouble()).toFloat()
                                    if (dist <= nodeRadiusPx) {
                                        tappedIdx = i
                                        break
                                    }
                                }

                                if (tappedIdx != null) {
                                    if (userPath.isEmpty()) {
                                        userPath.add(tappedIdx)
                                    } else {
                                        val lastNode = userPath.last()
                                        if (tappedIdx != lastNode) {
                                            if (userPath.size >= 2 && userPath[userPath.size - 2] == tappedIdx) {
                                                val removed = userPath.removeAt(userPath.size - 1)
                                                val pairToRemove = kotlin.math.min(removed, tappedIdx) to kotlin.math.max(removed, tappedIdx)
                                                userTraversedEdgePairs.remove(pairToRemove)
                                            } else if (isEdgeInLevel(lastNode, tappedIdx) && !isEdgeTraversed(lastNode, tappedIdx)) {
                                                userPath.add(tappedIdx)
                                                val pairToAdd = kotlin.math.min(lastNode, tappedIdx) to kotlin.math.max(lastNode, tappedIdx)
                                                userTraversedEdgePairs.add(pairToAdd)

                                                if (userTraversedEdgePairs.size == currentLevel.edges.size) {
                                                    isLevelCleared = true
                                                    val nowFormatted = java.text.SimpleDateFormat("hh:mm a", java.util.Locale.getDefault()).format(java.util.Date())
                                                    onGameFinished(
                                                        GameHistoryRecord(
                                                            id = System.currentTimeMillis().toString(),
                                                            gameName = "Dot Connect Level $levelNumber",
                                                            score = levelNumber * 100,
                                                            stars = 3,
                                                            titleTag = "🔴 ONE LINE MASTER",
                                                            accuracyText = "100% Solved",
                                                            highestStreak = levelNumber,
                                                            timestamp = "Today, $nowFormatted"
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                ) {
                    Canvas(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp)
                    ) {
                        fun getNodePos(index: Int): Offset {
                            val node = currentLevel.nodes[index]
                            return Offset(node.x * size.width, node.y * size.height)
                        }

                        // 1. Draw HIGH-CONTRAST clear guide lines (untraversed edges)
                        for (edge in currentLevel.edges) {
                            val isTraversed = isEdgeTraversed(edge.u, edge.v)
                            if (!isTraversed) {
                                val p1 = getNodePos(edge.u)
                                val p2 = getNodePos(edge.v)
                                // Outer track stroke (glowing sky blue)
                                drawLine(
                                    color = Color(0xFF38BDF8).copy(alpha = 0.45f),
                                    start = p1,
                                    end = p2,
                                    strokeWidth = 24f,
                                    cap = StrokeCap.Round
                                )
                                // Inner guide stroke (bright crisp white)
                                drawLine(
                                    color = Color.White,
                                    start = p1,
                                    end = p2,
                                    strokeWidth = 10f,
                                    cap = StrokeCap.Round
                                )
                            }
                        }

                        // 2. Draw Hint edge in glowing gold if active
                        hintEdge?.let { edge ->
                            val p1 = getNodePos(edge.first)
                            val p2 = getNodePos(edge.second)
                            drawLine(
                                color = Color(0xFFFFD600),
                                start = p1,
                                end = p2,
                                strokeWidth = 24f,
                                cap = StrokeCap.Round
                            )
                        }

                        // 3. Draw user traversed edges in vibrant neon color
                        for (i in 0 until userPath.size - 1) {
                            val p1 = getNodePos(userPath[i])
                            val p2 = getNodePos(userPath[i + 1])
                            drawLine(
                                color = currentLevel.themeDotColor,
                                start = p1,
                                end = p2,
                                strokeWidth = 22f,
                                cap = StrokeCap.Round
                            )
                        }

                        // 4. Live line to drag offset
                        if (userPath.isNotEmpty() && dragTouchOffset != null && !isLevelCleared) {
                            val lastPos = getNodePos(userPath.last())
                            drawLine(
                                color = currentLevel.themeDotColor.copy(alpha = 0.7f),
                                start = lastPos,
                                end = dragTouchOffset!!,
                                strokeWidth = 12f,
                                cap = StrokeCap.Round
                            )
                        }

                        // 5. Draw Node Dots (Circles with vibrant glow)
                        val dotRadiusPx = size.width * 0.052f
                        for (i in currentLevel.nodes.indices) {
                            val center = getNodePos(i)
                            val isVisited = userPath.contains(i)
                            val isLast = userPath.lastOrNull() == i

                            // Pulse halo for active dot
                            if (isLast) {
                                drawCircle(
                                    color = currentLevel.themeDotColor.copy(alpha = 0.25f),
                                    radius = dotRadiusPx * 2.3f,
                                    center = center
                                )
                                drawCircle(
                                    color = currentLevel.themeDotColor.copy(alpha = 0.5f),
                                    radius = dotRadiusPx * 1.6f,
                                    center = center
                                )
                            }

                            // Solid Vibrant Node Circle
                            drawCircle(
                                color = currentLevel.themeDotColor,
                                radius = dotRadiusPx,
                                center = center
                            )

                            // Inner white/bright core dot
                            drawCircle(
                                color = Color.White,
                                radius = dotRadiusPx * 0.38f,
                                center = center
                            )
                        }
                    }

                    // Level Victory Overlay Modal
                    if (isLevelCleared) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFF0F172A).copy(alpha = 0.92f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(24.dp)
                                    .clip(RoundedCornerShape(24.dp))
                                    .background(Color(0xFF1E293B))
                                    .border(1.5.dp, currentLevel.themeDotColor, RoundedCornerShape(24.dp))
                                    .padding(28.dp)
                            ) {
                                Text("🎉", fontSize = 48.sp)
                                Spacer(modifier = Modifier.height(10.dp))
                                Text(
                                    text = "LEVEL $levelNumber CLEARED!",
                                    color = Color.White,
                                    fontSize = 22.sp,
                                    fontWeight = FontWeight.Black
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "All lines connected in 1 continuous stroke!",
                                    color = Color(0xFF94A3B8),
                                    fontSize = 13.sp
                                )

                                Spacer(modifier = Modifier.height(24.dp))

                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(50.dp)
                                        .clip(RoundedCornerShape(25.dp))
                                        .background(currentLevel.themeDotColor)
                                        .clickable {
                                            loadLevel(levelNumber + 1)
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "NEXT LEVEL >",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Black,
                                        letterSpacing = 1.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TicTacToeGameDialog(
    onDismiss: () -> Unit,
    onGameFinished: (GameHistoryRecord) -> Unit
) {
    var gameStarted by remember { mutableStateOf(false) }
    // 0 = VS AI, 1 = 2 PLAYER, 2 = ONLINE MULTIPLAYER
    var selectedMode by remember { mutableIntStateOf(0) }
    val isVsAi = selectedMode == 0

    var board by remember { mutableStateOf(List(9) { "" }) }
    var currentPlayer by remember { mutableStateOf("X") }
    var winner by remember { mutableStateOf<String?>(null) } // "X", "O", "DRAW", or null
    var winningLine by remember { mutableStateOf<List<Int>?>(null) }

    var currentRound by remember { mutableIntStateOf(1) }
    var roundAnnouncementText by remember { mutableStateOf<String?>(null) }
    var showMultiplayerPopup by remember { mutableStateOf(false) }

    var xWins by remember { mutableIntStateOf(0) }
    var oWins by remember { mutableIntStateOf(0) }
    var ties by remember { mutableIntStateOf(0) }

    val winLineProgress = remember { androidx.compose.animation.core.Animatable(0f) }

    val checkWinCondition: (List<String>) -> Pair<String?, List<Int>?> = { currentBoard ->
        val lines = listOf(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
            listOf(0, 4, 8), listOf(2, 4, 6)
        )
        var resultWinner: String? = null
        var resultLine: List<Int>? = null

        for (line in lines) {
            val (a, b, c) = line
            if (currentBoard[a].isNotEmpty() && currentBoard[a] == currentBoard[b] && currentBoard[a] == currentBoard[c]) {
                resultWinner = currentBoard[a]
                resultLine = line
                break
            }
        }

        if (resultWinner == null && currentBoard.none { it.isEmpty() }) {
            resultWinner = "DRAW"
        }

        Pair(resultWinner, resultLine)
    }

    // Victory Line Animation (1 second duration)
    LaunchedEffect(winningLine) {
        if (winningLine != null && winningLine!!.size == 3) {
            winLineProgress.snapTo(0f)
            winLineProgress.animateTo(
                targetValue = 1f,
                animationSpec = androidx.compose.animation.core.tween(durationMillis = 1000)
            )
        } else {
            winLineProgress.snapTo(0f)
        }
    }

    var drawBlinkVisible by remember { mutableStateOf(true) }

    // Auto-restart match on DRAW with 2-time Blink Animation
    LaunchedEffect(winner) {
        if (winner == "DRAW") {
            repeat(2) {
                drawBlinkVisible = false
                kotlinx.coroutines.delay(250)
                drawBlinkVisible = true
                kotlinx.coroutines.delay(250)
            }
            kotlinx.coroutines.delay(300)
            board = List(9) { "" }
            winner = null
            winningLine = null
            currentPlayer = "X"
            roundAnnouncementText = "ROUND $currentRound RESTARTED!"
        } else {
            drawBlinkVisible = true
        }
    }

    // Round announcement auto-hide
    LaunchedEffect(roundAnnouncementText) {
        if (roundAnnouncementText != null) {
            kotlinx.coroutines.delay(1200)
            roundAnnouncementText = null
        }
    }

    fun resetBoard() {
        board = List(9) { "" }
        winner = null
        winningLine = null
        currentPlayer = "X"
    }

    fun makeAiMove() {
        if (winner != null) return
        val emptyIndices = board.mapIndexedNotNull { index, value -> if (value.isEmpty()) index else null }
        if (emptyIndices.isEmpty()) return

        var bestMove: Int? = null
        for (idx in emptyIndices) {
            val tempBoard = board.toMutableList()
            tempBoard[idx] = "O"
            if (checkWinCondition(tempBoard).first == "O") {
                bestMove = idx
                break
            }
        }

        if (bestMove == null) {
            for (idx in emptyIndices) {
                val tempBoard = board.toMutableList()
                tempBoard[idx] = "X"
                if (checkWinCondition(tempBoard).first == "X") {
                    bestMove = idx
                    break
                }
            }
        }

        if (bestMove == null && 4 in emptyIndices) {
            bestMove = 4
        }

        if (bestMove == null) {
            bestMove = emptyIndices.random()
        }

        val newBoard = board.toMutableList()
        newBoard[bestMove] = "O"
        board = newBoard

        val (w, line) = checkWinCondition(newBoard)
        if (w != null) {
            winner = w
            winningLine = line
            if (w == "O") {
                oWins++
                onGameFinished(
                    GameHistoryRecord(
                        id = System.currentTimeMillis().toString(),
                        gameName = "Tic Tac Toe",
                        score = 15,
                        stars = 1,
                        titleTag = "⭕❌ TIC TAC TOE",
                        accuracyText = "AI Defeat",
                        highestStreak = 0,
                        timestamp = "Just Now"
                    )
                )
            } else if (w == "DRAW") {
                ties++
                onGameFinished(
                    GameHistoryRecord(
                        id = System.currentTimeMillis().toString(),
                        gameName = "Tic Tac Toe",
                        score = 25,
                        stars = 2,
                        titleTag = "⭕❌ TIC TAC TOE",
                        accuracyText = "Draw Match",
                        highestStreak = 0,
                        timestamp = "Just Now"
                    )
                )
            }
        } else {
            currentPlayer = "X"
        }
    }

    fun handleCellClick(index: Int) {
        if (board[index].isNotEmpty() || winner != null) return
        if (isVsAi && currentPlayer != "X") return

        val newBoard = board.toMutableList()
        newBoard[index] = currentPlayer
        board = newBoard

        val (w, line) = checkWinCondition(newBoard)
        if (w != null) {
            winner = w
            winningLine = line
            if (w == "X") {
                xWins++
                onGameFinished(
                    GameHistoryRecord(
                        id = System.currentTimeMillis().toString(),
                        gameName = "Tic Tac Toe",
                        score = 50,
                        stars = 3,
                        titleTag = "⭕❌ TIC TAC TOE",
                        accuracyText = "100% Win",
                        highestStreak = xWins,
                        timestamp = "Just Now"
                    )
                )
            } else if (w == "O" && !isVsAi) {
                oWins++
                onGameFinished(
                    GameHistoryRecord(
                        id = System.currentTimeMillis().toString(),
                        gameName = "Tic Tac Toe",
                        score = 50,
                        stars = 3,
                        titleTag = "⭕❌ TIC TAC TOE",
                        accuracyText = "100% Win",
                        highestStreak = oWins,
                        timestamp = "Just Now"
                    )
                )
            } else if (w == "DRAW") {
                ties++
                onGameFinished(
                    GameHistoryRecord(
                        id = System.currentTimeMillis().toString(),
                        gameName = "Tic Tac Toe",
                        score = 25,
                        stars = 2,
                        titleTag = "⭕❌ TIC TAC TOE",
                        accuracyText = "Draw Match",
                        highestStreak = 0,
                        timestamp = "Just Now"
                    )
                )
            }
        } else {
            val nextPlayer = if (currentPlayer == "X") "O" else "X"
            currentPlayer = nextPlayer
        }
    }

    LaunchedEffect(currentPlayer, isVsAi, winner, gameStarted) {
        if (gameStarted && isVsAi && currentPlayer == "O" && winner == null) {
            kotlinx.coroutines.delay(400)
            makeAiMove()
        }
    }

    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(CyberBackground),
            color = CyberBackground
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.safeDrawing)
            ) {
                // Multiplayer "This feature will work soon" Popup Dialog
                if (showMultiplayerPopup) {
                    Dialog(onDismissRequest = { showMultiplayerPopup = false }) {
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = CyberSurface,
                            border = BorderStroke(2.dp, NeonGold),
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(24.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(60.dp)
                                        .clip(CircleShape)
                                        .background(NeonGold.copy(alpha = 0.2f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text("🌐", fontSize = 32.sp)
                                }

                                Text(
                                    text = "THIS FEATURE WILL WORK SOON!",
                                    color = NeonGold,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Black,
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                )

                                Text(
                                    text = "यह ऑनलाइन मल्टीप्लेयर सुविधा जल्द ही हमारे ग्लोबल सर्वर पर उपलब्ध होगी। (This feature will work soon!)",
                                    color = TextSecondary,
                                    fontSize = 13.sp,
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                )

                                Button(
                                    onClick = { showMultiplayerPopup = false },
                                    colors = ButtonDefaults.buttonColors(containerColor = NeonGold),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = "OK, UNDERSTOOD 👍",
                                        color = Color.Black,
                                        fontWeight = FontWeight.Black,
                                        fontSize = 14.sp
                                    )
                                }
                            }
                        }
                    }
                }

                // Tekken Style Round Overlay Banner
                if (roundAnnouncementText != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Black.copy(alpha = 0.88f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(
                                        Brush.horizontalGradient(
                                            colors = listOf(
                                                Color.Transparent,
                                                Color(0xFFFF2A2A).copy(alpha = 0.85f),
                                                NeonGold,
                                                Color(0xFFFF2A2A).copy(alpha = 0.85f),
                                                Color.Transparent
                                            )
                                        )
                                    )
                                    .padding(vertical = 18.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "⚡ TEKKEN BATTLE STAGE ⚡",
                                        color = NeonYellow,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Black,
                                        letterSpacing = 2.sp
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = roundAnnouncementText ?: "",
                                        color = Color.White,
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Black,
                                        letterSpacing = 1.5.sp
                                    )
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Text(
                                        text = "⚔️ FIGHT FOR GLORY! ⚔️",
                                        color = NeonCyan,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }
                }

                if (!gameStarted) {
                    // MODE SELECTION INTERFACE (3 Options - 20% Smaller)
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column {
                                Text(
                                    text = "⭕❌ TIC TAC TOE",
                                    color = NeonCyan,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Black,
                                    letterSpacing = 1.sp
                                )
                                Text(
                                    text = "Choose Game Mode (गेम मोड चुनें)",
                                    color = TextSecondary,
                                    fontSize = 11.sp
                                )
                            }

                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(CyberSurfaceVariant)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = TextPrimary
                                )
                            }
                        }

                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = "SELECT MODE TO PLAY",
                                color = TextPrimary,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )

                            // Option 1: VS AI
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(
                                        width = if (selectedMode == 0) 2.dp else 1.dp,
                                        color = if (selectedMode == 0) NeonCyan else CyberCardBorder,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable { selectedMode = 0 },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (selectedMode == 0) NeonCyan.copy(alpha = 0.15f) else CyberSurface
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(CircleShape)
                                            .background(NeonCyan.copy(alpha = 0.2f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("🤖", fontSize = 22.sp)
                                    }

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "1. VS BOT (AI)",
                                            color = NeonCyan,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                        Text(
                                            text = "Play against smart AI Computer bot",
                                            color = TextSecondary,
                                            fontSize = 11.sp
                                        )
                                    }

                                    if (selectedMode == 0) {
                                        Text(
                                            text = "✓ SELECTED",
                                            color = NeonCyan,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                    }
                                }
                            }

                            // Option 2: 2 PLAYER
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(
                                        width = if (selectedMode == 1) 2.dp else 1.dp,
                                        color = if (selectedMode == 1) NeonPurpleBright else CyberCardBorder,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable { selectedMode = 1 },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (selectedMode == 1) NeonPurpleBright.copy(alpha = 0.15f) else CyberSurface
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(CircleShape)
                                            .background(NeonPurpleBright.copy(alpha = 0.2f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("👥", fontSize = 22.sp)
                                    }

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "2. 2 PLAYER MODE",
                                            color = NeonPurpleBright,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                        Text(
                                            text = "Play locally with a friend on 1 phone",
                                            color = TextSecondary,
                                            fontSize = 11.sp
                                        )
                                    }

                                    if (selectedMode == 1) {
                                        Text(
                                            text = "✓ SELECTED",
                                            color = NeonPurpleBright,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                    }
                                }
                            }

                            // Option 3: ONLINE MULTIPLAYER (GLOBAL MATCHMAKING)
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(12.dp))
                                    .border(
                                        width = if (selectedMode == 2) 2.dp else 1.dp,
                                        color = if (selectedMode == 2) NeonGold else CyberCardBorder,
                                        shape = RoundedCornerShape(12.dp)
                                    )
                                    .clickable {
                                        selectedMode = 2
                                        showMultiplayerPopup = true
                                    },
                                colors = CardDefaults.cardColors(
                                    containerColor = if (selectedMode == 2) NeonGold.copy(alpha = 0.15f) else CyberSurface
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(42.dp)
                                            .clip(CircleShape)
                                            .background(NeonGold.copy(alpha = 0.2f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text("🌐", fontSize = 22.sp)
                                    }

                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "3. ONLINE MULTIPLAYER",
                                            color = NeonGold,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                        Text(
                                            text = "Connect with backend server & play globally",
                                            color = TextSecondary,
                                            fontSize = 11.sp
                                        )
                                    }

                                    if (selectedMode == 2) {
                                        Text(
                                            text = "✓ SELECTED",
                                            color = NeonGold,
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Black
                                        )
                                    }
                                }
                            }
                        }

                        Button(
                            onClick = {
                                if (selectedMode == 2) {
                                    showMultiplayerPopup = true
                                } else {
                                    resetBoard()
                                    currentRound = 1
                                    xWins = 0
                                    oWins = 0
                                    ties = 0
                                    gameStarted = true
                                    roundAnnouncementText = "ROUND 1 STARTED!"
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(44.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = when (selectedMode) {
                                    0 -> NeonCyan
                                    1 -> NeonPurpleBright
                                    else -> NeonGold
                                }
                            ),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "START GAME 🎮",
                                color = if (selectedMode == 1) Color.White else Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                letterSpacing = 1.sp
                            )
                        }
                    }
                } else {
                    // GAMEPLAY MATCH INTERFACE
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState()),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // Header with Back to Mode Selection & Close
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                IconButton(
                                    onClick = { gameStarted = false },
                                    modifier = Modifier
                                        .clip(CircleShape)
                                        .background(CyberSurfaceVariant)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Change Mode",
                                        tint = TextPrimary
                                    )
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = when (selectedMode) {
                                            0 -> "🤖 VS BOT"
                                            1 -> "👥 2 PLAYER"
                                            else -> "🌐 ONLINE GLOBAL"
                                        },
                                        color = when (selectedMode) {
                                            0 -> NeonCyan
                                            1 -> NeonPurpleBright
                                            else -> NeonGold
                                        },
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                    Text(
                                        text = "Round $currentRound • 3x3 Tactical Battle",
                                        color = TextSecondary,
                                        fontSize = 11.sp
                                    )
                                }
                            }

                            IconButton(
                                onClick = onDismiss,
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(CyberSurfaceVariant)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Close",
                                    tint = TextPrimary
                                )
                            }
                        }

                        // Top Control Buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = {
                                    resetBoard()
                                    roundAnnouncementText = "ROUND $currentRound RESTARTED!"
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = CyberSurfaceVariant),
                                border = BorderStroke(1.dp, CyberCardBorder),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = "Restart",
                                    tint = TextPrimary,
                                    modifier = Modifier.size(15.dp)
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "NEW ROUND",
                                    color = TextPrimary,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Button(
                                onClick = {
                                    xWins = 0
                                    oWins = 0
                                    ties = 0
                                    currentRound = 1
                                    resetBoard()
                                    roundAnnouncementText = "ROUND 1 STARTED!"
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .height(40.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = when (selectedMode) {
                                        0 -> NeonCyan
                                        1 -> NeonPurpleBright
                                        else -> NeonGold
                                    }
                                ),
                                shape = RoundedCornerShape(10.dp)
                            ) {
                                Text(
                                    text = "RESET SCORE",
                                    color = if (selectedMode == 1) Color.White else Color.Black,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }

                        // Score Card
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, CyberCardBorder, RoundedCornerShape(14.dp)),
                            colors = CardDefaults.cardColors(containerColor = CyberSurface)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text("PLAYER X", color = Color(0xFFFF2A2A), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                    Text("$xWins", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Black)
                                }

                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(26.dp)
                                        .background(CyberCardBorder)
                                )

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text("TIES", color = NeonYellow, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                    Text("$ties", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Black)
                                }

                                Box(
                                    modifier = Modifier
                                        .width(1.dp)
                                        .height(26.dp)
                                        .background(CyberCardBorder)
                                )

                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = when (selectedMode) {
                                            0 -> "AI BOT (O)"
                                            1 -> "PLAYER O"
                                            else -> "GLOBAL (O)"
                                        },
                                        color = Color(0xFF00BFFF),
                                        fontSize = 11.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text("$oWins", color = TextPrimary, fontSize = 20.sp, fontWeight = FontWeight.Black)
                                }
                            }
                        }

                        // Victory / Turn Banner Animation Card
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    when (winner) {
                                        "X" -> Color(0xFFFF2A2A).copy(alpha = 0.25f)
                                        "O" -> Color(0xFF00BFFF).copy(alpha = 0.25f)
                                        "DRAW" -> NeonYellow.copy(alpha = 0.25f)
                                        else -> CyberSurfaceVariant
                                    }
                                )
                                .border(
                                    2.dp,
                                    when (winner) {
                                        "X" -> Color(0xFFFF2A2A)
                                        "O" -> Color(0xFF00BFFF)
                                        "DRAW" -> NeonYellow
                                        else -> CyberCardBorder
                                    },
                                    RoundedCornerShape(12.dp)
                                )
                                .padding(horizontal = 14.dp, vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = when (winner) {
                                        "X" -> "🏆 VICTORY! PLAYER X WINS ROUND $currentRound! (+50 XP)"
                                        "O" -> if (isVsAi) "🤖 AI BOT VICTORY IN ROUND $currentRound!" else "🏆 VICTORY! PLAYER O WINS ROUND $currentRound! (+50 XP)"
                                        "DRAW" -> "🤝 DRAW MATCH! AUTO RESTARTING..."
                                        else -> if (isVsAi && currentPlayer == "O") "🤖 AI is thinking..." else "⚡ TURN: PLAYER $currentPlayer"
                                    },
                                    color = when (winner) {
                                        "X" -> Color(0xFFFF2A2A)
                                        "O" -> Color(0xFF00BFFF)
                                        "DRAW" -> NeonYellow
                                        else -> TextPrimary
                                    },
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Black
                                )
                            }
                        }

                        // Tic Tac Toe Grid Board (370dp = 20% larger than original 310dp)
                        Box(
                            modifier = Modifier
                                .size(370.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(CyberSurface)
                                .border(2.dp, CyberCardBorder, RoundedCornerShape(20.dp))
                                .padding(12.dp)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                for (row in 0..2) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .weight(1f),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        for (col in 0..2) {
                                            val index = row * 3 + col
                                            val cellValue = board[index]
                                            val isWinningCell = winningLine?.contains(index) == true

                                            Box(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .fillMaxHeight()
                                                    .clip(RoundedCornerShape(14.dp))
                                                    .background(
                                                        if (isWinningCell) {
                                                            if (winner == "X") Color(0xFFFF2A2A).copy(alpha = 0.3f)
                                                            else Color(0xFF00BFFF).copy(alpha = 0.3f)
                                                        } else CyberSurfaceVariant
                                                    )
                                                    .border(
                                                        width = if (isWinningCell) 3.dp else 1.dp,
                                                        color = if (isWinningCell) {
                                                            if (winner == "X") Color(0xFFFF2A2A) else Color(0xFF00BFFF)
                                                        } else CyberCardBorder,
                                                        shape = RoundedCornerShape(14.dp)
                                                    )
                                                    .clickable { handleCellClick(index) },
                                                contentAlignment = Alignment.Center
                                            ) {
                                                if (drawBlinkVisible) {
                                                    if (cellValue == "X") {
                                                        Text(
                                                            text = "X",
                                                            color = Color(0xFFFF2A2A),
                                                            fontSize = 102.sp,
                                                            fontWeight = FontWeight.Black
                                                        )
                                                    } else if (cellValue == "O") {
                                                        Text(
                                                            text = "O",
                                                            color = Color(0xFF00BFFF),
                                                            fontSize = 102.sp,
                                                            fontWeight = FontWeight.Black
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            // Clean Solid Victory Line Overlay (Strictly passes through exact center of winning 3 cells, no glow)
                            if (winningLine != null && winningLine!!.size == 3) {
                                Canvas(modifier = Modifier.matchParentSize()) {
                                    val w = size.width
                                    val h = size.height
                                    val cellW = w / 3f
                                    val cellH = h / 3f

                                    val lineCells = winningLine!!
                                    val startCell = lineCells[0]
                                    val endCell = lineCells[2]

                                    val startX = (startCell % 3 + 0.5f) * cellW
                                    val startY = (startCell / 3 + 0.5f) * cellH

                                    val endX = (endCell % 3 + 0.5f) * cellW
                                    val endY = (endCell / 3 + 0.5f) * cellH

                                    val curX = startX + (endX - startX) * winLineProgress.value
                                    val curY = startY + (endY - startY) * winLineProgress.value

                                    val lineColor = if (winner == "X") Color(0xFFFF2A2A) else Color(0xFF00BFFF)

                                    // Crisp Solid Victory Line
                                    drawLine(
                                        color = lineColor,
                                        start = Offset(startX, startY),
                                        end = Offset(curX, curY),
                                        strokeWidth = 12.dp.toPx(),
                                        cap = StrokeCap.Round
                                    )
                                }
                            }
                        }

                        // Bottom Row right under Game Box for Next Match
                        Row(
                            modifier = Modifier.width(370.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(8.dp),
                                color = CyberSurfaceVariant,
                                border = BorderStroke(1.dp, CyberCardBorder)
                            ) {
                                Text(
                                    text = "STAGE: ROUND $currentRound",
                                    color = NeonCyan,
                                    fontSize = 11.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                )
                            }

                            // Show Next Match option ONLY when someone wins (NOT on DRAW, as draw auto-restarts)
                            if (winner != null && winner != "DRAW") {
                                Button(
                                    onClick = {
                                        currentRound++
                                        resetBoard()
                                        roundAnnouncementText = "ROUND $currentRound STARTED!"
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = NeonGreen),
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.height(38.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Next Match",
                                        tint = Color.Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "NEXT MATCH ▶",
                                        color = Color.Black,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Black
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
