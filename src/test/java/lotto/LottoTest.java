package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    /*
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
     */
    @Test
    void 로또_등수_체크() {
        String input = "6000\n1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.generateLottoTest();
        inputView.inputStart(outputView);

        Lotto lotto = new Lotto(inputView.getLottoNumbers());
        List<Integer> expectedResult = Arrays.asList(1,1,1,1,2);
        assertEquals(expectedResult,lotto.start(outputView, inputView.getBonusNumber()));
    }
}
