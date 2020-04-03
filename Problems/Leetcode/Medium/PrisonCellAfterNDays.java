/*
    I tried to find the pattern of the loop.
    Well, the length of loop can be 1, 7, or 14.

    So once we enter the loop, every 14 steps must be the same state.

    The length of cells is even,
    so for any state, we can find a previous state.
    So all states are in a loop.

    It means that, after a single step from the initial state, we enter the loop.
*/
class PrisonCellAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        for (N = (N - 1) % 14 + 1; N > 0; --N) {
            int[] cells2 = new int[8];
            for (int i = 1; i < 7; ++i)
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            cells = cells2;
        }
        return cells;
    }
}