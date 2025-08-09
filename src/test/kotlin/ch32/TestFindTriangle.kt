package ch32

import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.asserter

class TestFindTriangle {
    fun isTriangle(aSide: Int, bSide: Int, cSide: Int): Int {
        val sortedSides = listOf(aSide, bSide, cSide).sorted()

        if (sortedSides.any { it <= 0 }) throw IllegalArgumentException("한 변의 길이는 양수여야 합니다.")

        val a = sortedSides[0]
        val b = sortedSides[1]
        val c = sortedSides[2]

        if (!(a + b > c && a + c > b && b + c > a)) throw IllegalArgumentException("두 변의 합은 나머지 한 변보다 커야합니다.")

        if (a == b && b == c) return 1
        if (a == b || b == c) return 2
        else return 3
    }

    @Test
    fun testEquilateralTriangle() {
        val sides = TriangleFixture.equilateralTriangles()
        sides.forEach {
            asserter.assertEquals(
                message = "정 삼각형이 아닙니다.",
                expected = 1,
                actual = isTriangle(it.first, it.second, it.third)
            )
        }
    }

    @Test
    fun testIsoscelesTriangle() {
        val sides = TriangleFixture.isoscelesTriangle()
        sides.forEach {
            asserter.assertEquals(
                message = "이등변 삼각형이 아닙니다.",
                expected = 2,
                actual = isTriangle(it.first, it.second, it.third)
            )
        }
    }

    @Test
    fun testScaleneTriangle() {
        val sides = TriangleFixture.scaleneTriangle()
        sides.forEach {
            asserter.assertEquals(
                message = "부등변 삼각형이 아닙니다.",
                expected = 3,
                actual = isTriangle(it.first, it.second, it.third)
            )
        }
    }

    @Test
    fun testNegative() {
        val sides = TriangleFixture.negativeTriangles()
        sides.forEach {
            assertFailsWith<IllegalArgumentException> {
                isTriangle(it.first, it.second, it.third)
            }
        }
    }

    @Test
    fun testNotTriangle() {
        val sides = TriangleFixture.notTriangles()
        sides.forEach {
            assertFailsWith<IllegalArgumentException> {
                isTriangle(it.first, it.second, it.third)
            }
        }
    }

    object TriangleFixture {
        fun notTriangles(): List<Triple<Int, Int, Int>> {
            return listOf(
                Triple(1, 0, 3),
                Triple(1, 2, 3),
                Triple(0, 0, 0),
            )
        }

        fun negativeTriangles(): List<Triple<Int, Int, Int>> {
            return listOf(
                Triple(-3, 3, 3),
                Triple(3, -3, 3),
                Triple(1, 1, -3),
            )
        }

        fun equilateralTriangles(): List<Triple<Int, Int, Int>> {
            return listOf(
                Triple(3, 3, 3),
                Triple(2, 2, 2),
                Triple(11, 11, 11),
            )
        }

        fun isoscelesTriangle(): List<Triple<Int, Int, Int>> {
            return listOf(
                Triple(1, 2, 2),
                Triple(3, 1, 3),
                Triple(2, 2, 3)
            )
        }

        fun scaleneTriangle(): List<Triple<Int, Int, Int>> {
            return listOf(
                Triple(2, 3, 4),
                Triple(11, 12, 4),
                Triple(5, 6, 7)
            )
        }
    }
}