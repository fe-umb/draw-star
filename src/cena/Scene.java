package cena;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

/**
 *
 * @author Fernanda P. Umberto
 */
public class Scene implements GLEventListener {

    private float xMin, xMax, yMin, yMax, zMin, zMax;
    GLU glu;

    @Override
    public void init(GLAutoDrawable drawable) {
        glu = new GLU();
        xMin = yMin = zMin = -1;
        xMax = yMax = zMax = 1;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glLoadIdentity();

        drawStar(gl);

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();

        if (height == 0) {
            height = 1;
        }
        float aspect = (float) width / height;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();


        if (width >= height) {
            gl.glOrtho(xMin * aspect, xMax * aspect, yMin, yMax, zMin, zMax);
        } else {
            gl.glOrtho(xMin, xMax, yMin / aspect, yMax / aspect, zMin, zMax);
        }

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        System.out.println("Reshape: " + width + ", " + height);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

    public void drawStar(GL2 gl) {
      
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(0, 1, 0);
        gl.glVertex2f(0f, 0.5f);
        gl.glVertex2f(-0.2f, 0);
        gl.glVertex2f(0.2f, 0f);
        gl.glVertex2f(-0.2f, 0);
        gl.glVertex2f(-0.7f, 0);
        gl.glVertex2f(-0.3f, -0.3f);
        gl.glVertex2f(0.2f, 0f);
        gl.glVertex2f(0.7f, 0);
        gl.glVertex2f(0.3f, -0.3f);
        gl.glVertex2f(0.3f, -0.3f);
        gl.glVertex2f(0f, -0.6f);
        gl.glVertex2f(0.8f, -1f);
        gl.glVertex2f(-0.3f, -0.3f);
        gl.glVertex2f(0f, -0.6f);
        gl.glVertex2f(-0.8f, -1f);
        gl.glVertex2f(-0.2f, 0);
        gl.glVertex2f(-0.3f, -0.3f);
        gl.glVertex2f(0f, -0.6f);
        gl.glVertex2f(-0.2f, 0);
        gl.glVertex2f(0f, -0.6f);
        gl.glVertex2f(0.2f, 0f);
        gl.glVertex2f(0.2f, 0f);
        gl.glVertex2f(0f, -0.6f);
        gl.glVertex2f(0.3f, -0.3f);
        
        gl.glEnd();
    }
}
