package app.reproductorm;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int posicion=0;
    MediaPlayer mr;
    MediaPlayer canciones []=new MediaPlayer[6];
    String nombres[]={"a","b","c", "d", "e", "f"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnPlay = findViewById(R.id.btnPlay);
        final Button btnStop = findViewById(R.id.btnStop);
        final Button btnAnterior = findViewById(R.id.btnAtras);
        final Button btnSiguiente = findViewById(R.id.btnNext);
        final ImageView imageView = findViewById(R.id.imageView);
        final TextView txtTitulo=findViewById(R.id.txtTitulo);
        canciones[0] = MediaPlayer.create(this, R.raw.sound);
        canciones[1] = MediaPlayer.create(this, R.raw.race);
        canciones[2] = MediaPlayer.create(this, R.raw.tea);
        canciones[3] = MediaPlayer.create(this, R.raw.sounddos);
        canciones[4] = MediaPlayer.create(this, R.raw.instrumento);
        canciones[5] = MediaPlayer.create(this, R.raw.sonrisa);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (canciones[posicion].isPlaying()) {
                    canciones[posicion].pause();
                    btnPlay.setBackgroundResource(R.drawable.reproducir);
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Pausa", Toast.LENGTH_SHORT);
                    mensaje.show();
                } else {
                    canciones[posicion].start();
                    txtTitulo.setText(nombres[posicion]);
                    btnPlay.setBackgroundResource(R.drawable.pausa);
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(canciones[posicion] != null){
                    canciones[posicion].stop();
                    recolocar();
                    posicion = 0;
                    btnPlay.setBackgroundResource(R.drawable.reproducir);
                    imageView.setImageResource(R.drawable.portada1);
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Stop", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }
        });
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posicion < canciones.length -1){

                    if(canciones[posicion].isPlaying()){
                        canciones[posicion].stop();
                        posicion++;
                        canciones[posicion].start();

                        if(posicion == 0){
                            imageView.setImageResource(R.drawable.portada1);
                        } else if(posicion == 1){
                            imageView.setImageResource(R.drawable.portada2);
                        }else if(posicion == 2){
                            imageView.setImageResource(R.drawable.portada3);
                        }

                    } else {
                        posicion++;

                        if(posicion == 0){
                            imageView.setImageResource(R.drawable.portada1);
                        } else if(posicion == 1){
                            imageView.setImageResource(R.drawable.portada2);
                        }else if(posicion == 2){
                            imageView.setImageResource(R.drawable.portada3);
                        }
                    }

                } else {

                    Toast mensaje = Toast.makeText(getApplicationContext(), "No hay mas canciones", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }
        });

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(posicion >= 1){

                    if(canciones[posicion].isPlaying()){
                        canciones[posicion].stop();
                        recolocar();
                        posicion--;

                        if(posicion == 0){
                            imageView.setImageResource(R.drawable.portada1);
                        } else if(posicion == 1){
                            imageView.setImageResource(R.drawable.portada2);
                        }else if(posicion == 2){
                            imageView.setImageResource(R.drawable.portada3);
                        }
                        canciones[posicion].start();
                    } else {
                        posicion--;

                        if(posicion == 0){
                            imageView.setImageResource(R.drawable.portada1);
                        } else if(posicion == 1){
                            imageView.setImageResource(R.drawable.portada2);
                        }else if(posicion == 2){
                            imageView.setImageResource(R.drawable.portada3);
                        }
                    }

                } else {
                    Toast mensaje = Toast.makeText(getApplicationContext(), "No hay mas canciones", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }
        });

    }
    public void recolocar(){ // Mete las canciones en el buffer
        canciones[0] = MediaPlayer.create(this, R.raw.sound);
        canciones[1] = MediaPlayer.create(this, R.raw.instrumento);
        canciones[2] = MediaPlayer.create(this, R.raw.tea);
        canciones[3] = MediaPlayer.create(this, R.raw.sounddos);
        canciones[4] = MediaPlayer.create(this, R.raw.instrumento);
        canciones[5] = MediaPlayer.create(this, R.raw.sonrisa);
    }
}
