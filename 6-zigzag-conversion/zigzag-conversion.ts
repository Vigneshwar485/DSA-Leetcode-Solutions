export function convert(s: string, numRows: number): string {
  if (numRows <= 1) return s;

  let direction = 1;
  let rowIndex = 0;

  /**
   * We initialize our rows with empty strings. Then, we run through the string
   * and add the characters one by one.
   */
  const rows = new Array(numRows).fill("");
  insertCharsIntoEachRow: for (let i = 0; i < s.length; i++) {
    const char = s[i];

    rows[rowIndex] += char;

    rowIndex += direction;

    if (
      rowIndex === 0 || // reached top
      rowIndex === numRows - 1 // reached bottom
    ) {
      direction *= -1;
    }
  }

  const result = rows.join("");
  return result;
}