package ahodanenok.algs4.ch_1_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RelativelyPrimeTest {

    @ParameterizedTest
    @MethodSource("getData")
    public void test(int n, boolean[][] result) {
        Assertions.assertArrayEquals(RelativelyPrime.sieve(n), result);
    }

    private static Stream<Arguments> getData() {
        return Stream.of(
                Arguments.of(0, new boolean[0][0]),
                Arguments.of(1, new boolean[][] {{ true }}),
                Arguments.of(2, new boolean[][] {
                    { true, true  },
                    { true, false }
                }),
                Arguments.of(3, new boolean[][] {
                    { true, true,  true  },
                    { true, false, true  },
                    { true, true,  false }
                }),
                Arguments.of(4, new boolean[][] {
                    { true, true,  true,  true  },
                    { true, false, true,  false },
                    { true, true,  false, true  },
                    { true, false, true,  false }
                }),
                Arguments.of(5, new boolean[][] {
                    { true, true,  true,  true,  true  },
                    { true, false, true,  false, true  },
                    { true, true,  false, true,  true  },
                    { true, false, true,  false, true  },
                    { true, true,  true,  true,  false }
                }),
                Arguments.of(6, new boolean[][] {
                    { true, true,  true,  true,  true,  true  },
                    { true, false, true,  false, true,  false },
                    { true, true,  false, true,  true,  false },
                    { true, false, true,  false, true,  false },
                    { true, true,  true,  true,  false, true  },
                    { true, false, false, false, true,  false }
                }),
                Arguments.of(7, new boolean[][] {
                    { true, true,  true,  true,  true,  true,  true  },
                    { true, false, true,  false, true,  false, true  },
                    { true, true,  false, true,  true,  false, true  },
                    { true, false, true,  false, true,  false, true  },
                    { true, true,  true,  true,  false, true,  true  },
                    { true, false, false, false, true,  false, true  },
                    { true, true,  true,  true,  true,  true,  false }
                }),
                Arguments.of(8, new boolean[][] {
                    { true, true,  true,  true,  true,  true,  true,  true  },
                    { true, false, true,  false, true,  false, true,  false },
                    { true, true,  false, true,  true,  false, true,  true  },
                    { true, false, true,  false, true,  false, true,  false },
                    { true, true,  true,  true,  false, true,  true,  true  },
                    { true, false, false, false, true,  false, true,  false },
                    { true, true,  true,  true,  true,  true,  false, true  },
                    { true, false, true,  false, true,  false, true,  false }
                }),
                Arguments.of(9, new boolean[][] {
                    { true, true,  true,  true,  true,  true,  true,  true,  true  },
                    { true, false, true,  false, true,  false, true,  false, true  },
                    { true, true,  false, true,  true,  false, true,  true,  false },
                    { true, false, true,  false, true,  false, true,  false, true  },
                    { true, true,  true,  true,  false, true,  true,  true,  true  },
                    { true, false, false, false, true,  false, true,  false, false },
                    { true, true,  true,  true,  true,  true,  false, true,  true  },
                    { true, false, true,  false, true,  false, true,  false, true  },
                    { true, true,  false, true,  true,  false, true,  true,  false }
                }),
                Arguments.of(10, new boolean[][] {
                    { true, true,  true,  true,  true,  true,  true,  true,  true,  true  },
                    { true, false, true,  false, true,  false, true,  false, true,  false },
                    { true, true,  false, true,  true,  false, true,  true,  false, true  },
                    { true, false, true,  false, true,  false, true,  false, true,  false },
                    { true, true,  true,  true,  false, true,  true,  true,  true,  false },
                    { true, false, false, false, true,  false, true,  false, false, false },
                    { true, true,  true,  true,  true,  true,  false, true,  true,  true  },
                    { true, false, true,  false, true,  false, true,  false, true,  false },
                    { true, true,  false, true,  true,  false, true,  true,  false, true  },
                    { true, false, true,  false, false, false, true,  false, true,  false }
                }));
    }
}
