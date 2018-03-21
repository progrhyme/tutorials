class CubeCalculatorTest extends org.scalatest.FunSuite {
  test("CubeCalculator.cube(3) === 27") {
    assert(CubeCalculator.cube(3) === 27)
  }

  // New test case
  test("CubeCalculator.cube(0) === 0") {
    assert(CubeCalculator.cube(0) === 0)
  }
}
