import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Caleb Farnie
 * @date 15 January 2021
 * 
 * Copyright 2021 Caleb Farnie
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

public class GenerateListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		int width, height;
		
		String text = GenerateEmbedCode.url.getText();
		
		String videoID = GenerateEmbedCode.processURL(text);
		width = Integer.parseInt(GenerateEmbedCode.width.getText());
		height = Integer.parseInt(GenerateEmbedCode.height.getText());
		
		String embedCode = GenerateEmbedCode.generateEmbed(videoID, width, height, GenerateEmbedCode.autoplay_bool,
				GenerateEmbedCode.loop_bool, GenerateEmbedCode.fullscreen_bool);
		
		GenerateEmbedCode.embed.setText(embedCode);
		GenerateEmbedCode.embed.selectAll();
	}

}
