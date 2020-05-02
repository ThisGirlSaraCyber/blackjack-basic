export default hand => {
  const points = hand.map(card => (card.number > 10 ? 10 : card.number))
  const sum = points.reduce((ret, cur) => ret + cur)

  if (sum > 21) {
    return 'Bust'
  }

  if (sum <= 11 && points.some(a => a === 1)) {
    return sum + 10
  }
  return sum
}
